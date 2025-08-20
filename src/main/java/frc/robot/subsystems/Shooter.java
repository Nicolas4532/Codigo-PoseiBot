package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    
    public SparkMax motor; // NEO en outtake
    
    public Shooter() {
        motor = new SparkMax(10, MotorType.kBrushless);
    }

    public void shoot(double speed) {
        motor.set(speed); 
    }

    public void reverse(double speed) {
        motor.set(-speed); 
    }

    public void stop() {
        motor.set(0); 
    }
}
