package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
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

  // ---- Variables para el toggle del botón Y ----
  boolean giroActivo = false;   // Saber si está girando
  boolean lastYState = false;   // Estado anterior del botón Y
  
  @Override
  public void robotInit() {
    drivetrain = new Drivetrain();
    elevador = new Elevador();
    lifter = new Lifter();
    shooter = new Shooter();
    controller = new XboxController(0);
  }
  
  @Override
  public void robotPeriodic() {}
 
  @Override
<<<<<<< HEAD
  public void autonomousInit() {
    startTime = Timer.getFPGATimestamp(); // Guarda el tiempo en el que inició autonomo
=======
public void autonomousInit() {
  startTime = Timer.getFPGATimestamp(); // Guarda el tiempo en el que inició autonomo
}

@Override
public void autonomousPeriodic() {
  double timeElapsed = Timer.getFPGATimestamp() - startTime;

  if (timeElapsed < 3.0) {
    drivetrain.drive(-0.5, 0);  // Avanza hacia adelante por 3 segundos
  } else {
    drivetrain.drive(0, 0);     // Se detiene después
>>>>>>> d2121f7430e1053b28dc8a6568e00366526ac53b
  }

  @Override
  public void autonomousPeriodic() {
    double timeElapsed = Timer.getFPGATimestamp() - startTime;

    if (timeElapsed >= 2.0 && timeElapsed < 4.0) {  // Si el tiempo que ha pasado en mayor o igual a 2 y menor a 4
      shooter.shoot(0.5); // Dispara a 0.5 de velocidad
    } else {
      shooter.stop(); // Se detiene después de 4s o antes de iniciar
    }

    if (timeElapsed < 0.9) {
      elevador.subir();  // Sube por .9 segundos (limite)
    } else {
      elevador.detenerse();
    }

    if (timeElapsed < 2.0) {
      drivetrain.drive(-0.5, 0);  // Avanza hacia adelante por 3 segundos
    } else {
      drivetrain.drive(0, 0);
    }
  } 

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    // ---- Toggle con botón Y ----
    boolean currentYState = controller.getYButton();
    if (currentYState && !lastYState) { // Cuando se presiona
      giroActivo = !giroActivo; // Cambia el estado
    }
    lastYState = currentYState;

    // Si el giro está activo, el robot solo gira a la derecha
    if (giroActivo) {
      drivetrain.drive(0, 0.35); // Gira a la derecha
      return; // Ignora el resto de controles mientras gira
    }

    // ---- Control de velocidad con A y B ----
    if (controller.getAButton()) {
      drivelimit = 1;
    }
    if (controller.getBButton()) {
      drivelimit = 0.5;
    }

    drivetrain.drive(controller.getRightY() * drivelimit, controller.getLeftX() * drivelimit);

    // ---- Elevador ----
    if (controller.getRightBumperButton()) {
      elevador.subir();
    } else if (controller.getLeftBumperButton()) {
      elevador.bajar();
    } else {
      elevador.detenerse();
    }

    // ---- Lifter ----
    if (controller.getXButton()) {
      lifter.lift();
    } else {
      lifter.hold();
    }

<<<<<<< HEAD
    // ---- Shooter ----
    double rightTrigger = controller.getRawAxis(3); // Disparo
=======
    // --- Shooter con triggers proporcionales ---
    double rightTrigger = controller.getRawAxis(3); // Shoot
>>>>>>> d2121f7430e1053b28dc8a6568e00366526ac53b
    double leftTrigger = controller.getRawAxis(2);  // Reversa

    if (rightTrigger > 0.05) { // para que no se active solo
      shooter.shoot(rightTrigger); // Shooter dispara proporcionalmente a cuanto presional es gatillo
    } else if (leftTrigger > 0.05) {
      shooter.reverse(leftTrigger); // shooter va en reversa proporcional a cuanto presionas el gatillo
    } else {
      shooter.stop();
    }
  }
}
