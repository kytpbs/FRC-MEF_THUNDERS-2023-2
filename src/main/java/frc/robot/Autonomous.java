package frc.robot;

import static frc.robot.Constants.TimerConstants.timer;
import static frc.robot.Constants.DriveConstants.driveTrain;

public class Autonomous {
    public static void Timed() {
        timer.start();
        if (timer.get() < 5) {
            driveTrain.arcadeDrive(0.5, 0);
        }
        else {
            driveTrain.arcadeDrive(0, 0);
            timer.stop();
        }
    }

    public static void Camera() {

    }

    public static void Stabilize() {

    }

    public static void Gyro() {

    }
}
