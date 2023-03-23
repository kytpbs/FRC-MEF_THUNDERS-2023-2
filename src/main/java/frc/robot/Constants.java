package frc.robot;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.AnalogPotentiometer;

public class Constants {
    static class DriveConstants {
        public static final WPI_VictorSPX rightMotor1 = new WPI_VictorSPX(1);
        public static final WPI_VictorSPX rightMotor2 = new WPI_VictorSPX(2);
        
        public static final WPI_VictorSPX leftMotor1 = new WPI_VictorSPX(3);
        public static final WPI_VictorSPX leftMotor2 = new WPI_VictorSPX(4);

        public static final MotorControllerGroup rightMotorsGroup = new MotorControllerGroup(rightMotor1, rightMotor2);
        public static final MotorControllerGroup leftMotorsGroup = new MotorControllerGroup(leftMotor1, leftMotor2);

        public static final DifferentialDrive driveTrain = new DifferentialDrive(leftMotorsGroup,rightMotorsGroup);
    }
    static class ElevatorConstants {
        public static final DigitalInput toplimitSwitch = new DigitalInput(0);
        public static final DigitalInput bottomlimitSwitch = new DigitalInput(1);
        public static final Spark Elevator =new Spark(2);
        public static final Spark Virtical_Elevator =new Spark(3);
        public static final AnalogPotentiometer Elevator_Hand = new AnalogPotentiometer(0, 180, 30);
    }
    static class JoystickConstants {
        public static final Joystick stick = new Joystick(0);
    }
    static class TimerConstants {
        public static final Timer timer = new Timer();
    }
    static class AutoConstants {
        public static final String kTimedAuto = "Timer Auto";
        public static final String kGyroAuto = "Gyro Auto";
        public static final String kCameraAuto = "Camera Auto";
        public static final String kStabilize = "Stabilize Auto";
    }
}
