package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public  class Shooter extends SubsystemBase {
    
    public SparkMax motor; //kitbot neo
    public Shooter() {
        motor = new SparkMax(9, MotorType.kBrushless);
    }
public void shoot() {
    motor.set(1); 
}
public void stop() {
    motor.set(0); 
}
}