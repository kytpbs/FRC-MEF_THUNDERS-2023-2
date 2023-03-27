package frc.robot;

import edu.wpi.first.math.controller.PIDController;

import static frc.robot.Constants.DriveConstants.driveTrain;
import static frc.robot.Constants.ElevatorConstants.Redline;
import static frc.robot.Constants.ElevatorConstants.Elevator;
import static frc.robot.Constants.ElevatorConstants.Vertical_Elevator;
import static frc.robot.Constants.ElevatorConstants.toplimitSwitch;
import static frc.robot.Constants.ElevatorConstants.bottomlimitSwitch;
import static frc.robot.Constants.ElevatorConstants.Neo;
import static frc.robot.Constants.JoystickConstants.stick;

public class Teleop {
  private static double Neo_speed = 0;
  private static boolean runpid = true;
  private static double pid_target = 0;
  static PIDController pid = new PIDController(0.3, 0, 0);
    public static void drive() {
        driveTrain.arcadeDrive(stick.getZ(), stick.getY(), true);
    }

    public static void elevator() {
      if (stick.getPOV() == 0) {
        if (toplimitSwitch.get()) {
            Elevator.set(0.8);
          }
        }
      if (stick.getPOV() == 180) {
        if (bottomlimitSwitch.get()) {
          Elevator.set(-0.8);
        }
      }
      if (stick.getPOV() == -1) {
        Elevator.set(0);
      }

      if (!bottomlimitSwitch.get()) {
        if (Elevator.get() != 0 && Elevator.get() < 0) {
          Elevator.set(0);
        }
      }
      if (!toplimitSwitch.get()) {
        if (Elevator.get() != 0 && Elevator.get() > 0) {
          Elevator.set(0);
        }
      }
      if (stick.getRawButtonPressed(1)) {
        Vertical_Elevator.set(0.6);
      }
      if (stick.getRawButtonReleased(1)) {
        Vertical_Elevator.set(0);
      }
      if (stick.getRawButtonPressed(2)) {
        Vertical_Elevator.set(-0.6);
      }
      if (stick.getRawButtonReleased(2)) {
        Vertical_Elevator.set(0);
      }
      if (stick.getRawButtonPressed(5)) {
        Redline.set(0.6);
      }
      if (stick.getRawButtonReleased(5)) {
        Redline.set(0);
      }
      if (stick.getRawButtonPressed(6)) {
        Redline.set(-0.6);
      }
      if (stick.getRawButtonReleased(6)) {
        Redline.set(0);
      }

      /* 
        if (stick.getRawButtonPressed(5)) {
            Elevator.set(0.8);
        }
        if (stick.getRawButtonReleased(5)) {
            Elevator.set(0);
        }
        if (stick.getRawButtonPressed(6)) {
          Elevator.set(-0.8);
        }
        if (stick.getRawButtonReleased(6)) {
            Elevator.set(0);
        }

        if (stick.getRawButtonPressed(1)) {
            ABCD.set(0.8);
        }
        if (stick.getRawButtonReleased(1)) {
           ABCD.set(0);
        }
        if (stick.getRawButtonPressed(2)) {
           ABCD.set(-0.8);
        }
        if (stick.getRawButtonReleased(2)) {
           ABCD.set(0);
        }


        if (stick.getRawButtonPressed(7)) {
            Virtical_Elevator.set(0.8);
        }
        if (stick.getRawButtonReleased(7)) {
            Virtical_Elevator.set(0);
        }
        if (stick.getRawButtonPressed(8)) {
            Virtical_Elevator.set(-0.8);
        }
        if (stick.getRawButtonReleased(8)) {
            Virtical_Elevator.set(0);
        }
        */
    }

    public static void Neo() {
      if (stick.getRawButtonPressed(3)) {
        double Neo_speed = 0.5;
        runpid = false;
      }
      if (stick.getRawButtonReleased(3)) {
        Neo.set(0);
        pid_target = Neo.getEncoder().getPosition();
        runpid = true;
      }
      if (stick.getRawButtonPressed(4)) {
        double Neo_speed = -0.3;
        runpid = false;
      }
      if (stick.getRawButtonReleased(4)) {
        Neo.set(0);
        pid_target = Neo.getEncoder().getPosition();
        runpid = true;
      }
      if (runpid) {
        double Neo_speed = pid.calculate(Neo.getEncoder().getPosition(), pid_target);
      }
      Neo.set(Neo_speed);

    }


}
