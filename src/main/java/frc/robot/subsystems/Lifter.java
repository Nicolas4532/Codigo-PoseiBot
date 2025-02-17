package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public  class Lifter extends SubsystemBase {
    
    public SparkMax lifterMotor; //Lifter neo c planetary gearbox
    public Lifter() {
        lifterMotor = new SparkMax(8, MotorType.kBrushless);
    }
public void lift() {
    lifterMotor.set(1); 
}
public void hold() {
    lifterMotor.set(0); 
}
}