package frc.robot;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

public class Constants {
    static class DriveConstants {
        public static final VictorSP rightMotor1 = new VictorSP(0);
        public static final VictorSP rightMotor2 = new VictorSP(1);
        
        public static final VictorSP leftMotor1 = new VictorSP(2);
        public static final VictorSP leftMotor2 = new VictorSP(3);

        public static final MotorControllerGroup rightMotorsGroup = new MotorControllerGroup(rightMotor1, rightMotor2);
        public static final MotorControllerGroup leftMotorsGroup = new MotorControllerGroup(leftMotor1, leftMotor2);

        public static final DifferentialDrive driveTrain = new DifferentialDrive(leftMotorsGroup,rightMotorsGroup);
    }
    static class ElevatorConstants {
        public static final DigitalInput toplimitSwitch = new DigitalInput(0);
        public static final DigitalInput bottomlimitSwitch = new DigitalInput(1);
        public static final Spark Elevator =new Spark(5);
    }
    static class JoystickConstants {
        public static final Joystick stick = new Joystick(0);
    }
    static class TimerConstants {
        public static final Timer timer = new Timer();
    }
}
