package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lifter extends SubsystemBase {

    public SparkMax lifterMotorLeader; // neo en toughbox
    public SparkMax lifterMotorFollower; // neo en toughbox

    public Lifter() {

        lifterMotorLeader = new SparkMax(8, MotorType.kBrushless);
        lifterMotorFollower = new SparkMax(9, MotorType.kBrushless);

        SparkMaxConfig baseConfig = new SparkMaxConfig();
        SparkMaxConfig lifterMotorFollowerConfig = new SparkMaxConfig();

        baseConfig.idleMode(IdleMode.kBrake);

        lifterMotorFollowerConfig
                .apply(baseConfig)
                .follow(lifterMotorLeader);

        lifterMotorLeader.configure(baseConfig, com.revrobotics.spark.SparkBase.ResetMode.kResetSafeParameters,
                PersistMode.kNoPersistParameters);
        lifterMotorFollower.configure(lifterMotorFollowerConfig,
                com.revrobotics.spark.SparkBase.ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    }

    public void lift() {
        lifterMotorLeader.set(-1);
    }

    public void hold() {
        lifterMotorLeader.set(0);
    }

    public void abajo() {
        lifterMotorLeader.set(1);
    }
}