package frc.robot;

import static frc.robot.Constants.ElevatorConstants.Neo;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Dashboard {
    public static void Put_Dashboard_Init() {
        Neo.getEncoder().setPosition(0);
        SmartDashboard.putNumber("Meter away from apriltag",15);
        SmartDashboard.putNumber("Neo pos", 50);
    }

    public static void Put_Dashboard_Periodic() {
        SmartDashboard.putNumber("Neo Encoder", Neo.getEncoder().getPosition());
    }
}
