package frc.robot;

import static frc.robot.Constants.TimerConstants.timer;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import static frc.robot.Constants.ElevatorConstants.Redline;
import static frc.robot.Constants.DriveConstants.driveTrain;

public class Autonomous {
    public static void Timed() {
        timer.start();
        while (timer.get() < 2) {
            Redline.set(-0.7);
        }
        timer.reset();
        while (timer.get() < 4) {
            driveTrain.arcadeDrive(0, -0.5);
        }
        timer.stop();
        timer.reset();
        driveTrain.stopMotor();
    
    }

    public static void Camera() {
        Integer Wanted_Area_Meters = (int)SmartDashboard.getNumber("Meter away from apriltag", 15);
        PhotonVision.Auto(Wanted_Area_Meters, 0.8, 1);
    }

    public static void Stabilize() {

    }

    public static void Gyro() {

    }

    public static void init(String autoSelected) {
        switch (autoSelected) {
            case "Timed":
                Timed();
                break;
            case "Camera":
                Camera();
                break;
            case "Stabilize":
                Stabilize();
                break;
            case "Gyro":
                Gyro();
                break;
            default:
                Timed();
                break;
        }
    }
}
