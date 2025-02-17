package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public  class Intake extends SubsystemBase {
    
    public SparkMax motor; //cim intake cangrejo
    public Intake() {
        motor = new SparkMax(7, MotorType.kBrushed);
    }
        public void jalar() {
    motor.set(1); 
}
public void parar() {
    motor.set(0); 
}
}