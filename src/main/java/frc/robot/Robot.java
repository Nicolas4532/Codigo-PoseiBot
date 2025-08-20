package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.commands.DriveStraight;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevador;
import frc.robot.subsystems.Lifter;
import frc.robot.subsystems.Shooter; 

public class Robot extends TimedRobot {

  public Drivetrain drivetrain;
  public Shooter shooter;
  public Elevador elevador;
  public Lifter lifter;
  public XboxController controller;
  public double startTime;
    
  public Robot() {}

  double drivelimit = 1;
  
  @Override
  public void robotInit() {
    drivetrain = new Drivetrain();
    elevador = new Elevador();
    lifter = new Lifter();
    shooter = new Shooter();
    controller = new XboxController(0);
  }
  
  @Override
    //AUTONOMO!
  public void robotPeriodic() {}
 
  @Override
public void autonomousInit() {
  startTime = Timer.getFPGATimestamp(); // Guarda el tiempo en el que inició auton
}

@Override
public void autonomousPeriodic() {
  double timeElapsed = Timer.getFPGATimestamp() - startTime;

  if (timeElapsed < 3.0) {
    drivetrain.drive(-0.5, 0);  // Avanza hacia adelante por 3 segundos
  } else {
    drivetrain.drive(0, 0);     // Se detiene después
  }
}

  @Override
 //TELEOPERADO!

  public void teleopInit() {}

  @Override
public void teleopPeriodic() {

    if (controller.getAButton()) {
      drivelimit = 1;
    }
    if (controller.getBButton()) {
      drivelimit = 0.5;
    }

    drivetrain.drive(controller.getRightY() * drivelimit, controller.getLeftX() * drivelimit);

    if (controller.getRightBumperButton()) {
      elevador.subir();
    } else if (controller.getLeftBumperButton()) {
      elevador.bajar();
    } else {
      elevador.detenerse();
    }

    if (controller.getXButton()) {
      lifter.lift();
    } else {
      lifter.hold();
    }

    // --- Shooter con triggers proporcionales ---
    double rightTrigger = controller.getRawAxis(3); // Disparo
    double leftTrigger = controller.getRawAxis(2);  // Reversa

    if (rightTrigger > 0.05) { // deadband pequeño
      shooter.shoot(rightTrigger);
    } else if (leftTrigger > 0.05) {
      shooter.reverse(leftTrigger);
    } else {
      shooter.stop();
    }
  }
}