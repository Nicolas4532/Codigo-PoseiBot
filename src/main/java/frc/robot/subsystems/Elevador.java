package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public  class Elevador extends SubsystemBase {
    
    public SparkMax elevadorMotorLeader; //elevador cims en toughbox
    public SparkMax elevadorMotorFollower; //elevador cim en toughbox
    public Elevador() {

    elevadorMotorLeader = new SparkMax(6, MotorType.kBrushed);
    elevadorMotorFollower = new SparkMax(7, MotorType.kBrushed);

    SparkMaxConfig baseConfig = new SparkMaxConfig();
    //SparkMaxConfig elevadorMotorLeaderConfig = new SparkMaxConfig();
    SparkMaxConfig elevadorMotorFollowerConfig = new SparkMaxConfig();

    baseConfig.idleMode(IdleMode.kBrake);

    elevadorMotorFollowerConfig
    .apply(baseConfig)
    .follow(elevadorMotorLeader);

    elevadorMotorLeader.configure(baseConfig,com.revrobotics.spark.SparkBase.ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    elevadorMotorFollower.configure(elevadorMotorFollowerConfig,com.revrobotics.spark.SparkBase.ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
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