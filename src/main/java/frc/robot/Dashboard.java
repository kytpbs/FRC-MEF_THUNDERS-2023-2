package frc.robot;

import static frc.robot.Constants.ElevatorConstants.Neo;
import static frc.robot.Constants.DriveConstants.leftEncoder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Dashboard {
    public static void Put_Dashboard_Init() {
        Neo.getEncoder().setPosition(0);
        leftEncoder.reset();
        SmartDashboard.putNumber("Meter away from apriltag",15);
        SmartDashboard.putNumber("Neo pos", 50);
    }

    public static void Put_Dashboard_Periodic() {
        SmartDashboard.putNumber("Neo Encoder", Neo.getEncoder().getPosition());
        SmartDashboard.putNumber("Left Enkoder", leftEncoder.get());
    }
}
