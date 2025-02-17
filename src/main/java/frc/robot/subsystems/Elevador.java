package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public  class Elevador extends SubsystemBase {
    
    public SparkMax elevadorMotorLeader; //elevador cims en toughbox
    public SparkMax elevadorMotorFollower; //elevador cim en toughbox
    public Elevador() {

    elevadorMotorLeader = new SparkMax(5, MotorType.kBrushless);
    elevadorMotorFollower = new SparkMax(6, MotorType.kBrushless);
    elevadorMotorFollower.setLeader(elevadorMotorLeader);
    elevadorMotorFollower.follow(elevadorMotorLeader);

}
    public void subir() {
        elevadorMotorLeader.set(1); 
    }
    public void detenerse() {
        elevadorMotorLeader.set(0);
    }
    public void bajar() {
        elevadorMotorLeader.set(-1); 
    }
}
