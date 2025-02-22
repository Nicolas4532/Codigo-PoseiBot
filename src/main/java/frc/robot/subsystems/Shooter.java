package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public  class Shooter extends SubsystemBase {
    
    public SparkMax motor; //neo en outake
    public Shooter() {
        motor = new SparkMax(10, MotorType.kBrushless);
    }
public void shoot() {
    motor.set(1); 
}
public void stop() {
    motor.set(0); 
}
public void reverse() {
    motor.set(-1); 
}

}