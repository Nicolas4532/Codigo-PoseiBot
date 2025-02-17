
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevador;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Lifter;
import frc.robot.subsystems.Shooter; 

public class Robot extends TimedRobot {

  public Drivetrain drivetrain;
  public Intake intake;
  public Shooter shooter;
  public Elevador elevador;
  public Lifter lifter;
  public XboxController controller;
    
  public Robot() {}
  
  @Override
  public void robotInit() {
    System.out.println("Subsistemas inicializados correctamente");
    drivetrain = new Drivetrain();
    elevador = new Elevador();
    intake = new Intake();
    lifter = new Lifter();
    shooter = new Shooter();
    controller = new XboxController(0);
  }
  
  @Override
  public void robotPeriodic() {}
 
  @Override
  public void autonomousInit() {}

  @Override
  
  //AUTONOMO!

  public void autonomousPeriodic() {
    
  //leftMotor.set(1);
  //rightMotor.set(1);
  }

  @Override
 //TELEOPERADO!

  public void teleopInit() {}

  @Override

  public void teleopPeriodic() {
   
    drivetrain.drive(controller.getRightY(), controller.getLeftX());

      if (controller.getAButton()) {
        shooter.shoot();
      } else  {
        shooter.stop();
      }
      if (controller.getBButton()) {
        intake.jalar();
      } else  {
        intake.parar();
      }
      if (controller.getLeftBumperButton()) {
        elevador.bajar();
      } else  {
        elevador.detenerse();
      }
      if (controller.getRightBumperButton()) {
        elevador.subir();
      } else  {
        elevador.detenerse();
      }
      if (controller.getXButton()) {
        lifter.lift();
      } else  {
        lifter.hold();
      }
  } 
}