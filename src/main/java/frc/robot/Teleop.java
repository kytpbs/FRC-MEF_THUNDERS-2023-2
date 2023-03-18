package frc.robot;
import static frc.robot.Constants.DriveConstants.driveTrain;
import static frc.robot.Constants.ElevatorConstants.Elevator;
import static frc.robot.Constants.ElevatorConstants.Virtical_Elevator;
import static frc.robot.Constants.ElevatorConstants.toplimitSwitch;
import static frc.robot.Constants.ElevatorConstants.bottomlimitSwitch;
import static frc.robot.Constants.JoystickConstants.stick;

public class Teleop {
    public static void drive() {
        driveTrain.arcadeDrive(stick.getZ() * (0.7) , stick.getY(), true);
    }

    public static void elevator() {
        if (stick.getPOV() == 0) {
            if (toplimitSwitch.get()){
              Elevator.set(-1);
            }
          }
          else {
            if (stick.getPOV() == 180) {
              if (bottomlimitSwitch.get()){
                Elevator.set(1);
              }
            }
            else {
              Elevator.set(0);
            }
          }  
        if (stick.getRawButtonPressed(1)) {
            Virtical_Elevator.set(0.5);
        }
        if (stick.getRawButtonReleased(1)) {
            Virtical_Elevator.set(0);
        }
        if (stick.getRawButtonPressed(2)) {
            Virtical_Elevator.set(-0.5);
        }
        if (stick.getRawButtonReleased(2)) {
            Virtical_Elevator.set(0);
        }
        
        
        if (!bottomlimitSwitch.get()) {
            Elevator.set(0);
        }
          if (!toplimitSwitch.get()) {
            Elevator.set(0);
          }
    }
}
