package frc.robot;
import org.photonvision.PhotonCamera;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.util.Units;


public class Constants {
    static class DriveConstants {
        public static final WPI_VictorSPX rightMotor1 = new WPI_VictorSPX(1);
        public static final WPI_VictorSPX rightMotor2 = new WPI_VictorSPX(2);
        
        public static final WPI_VictorSPX leftMotor1 = new WPI_VictorSPX(3);
        public static final WPI_VictorSPX leftMotor2 = new WPI_VictorSPX(4);

        public static final Encoder leftEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k2X);

        public static final MotorControllerGroup rightMotorsGroup = new MotorControllerGroup(rightMotor1, rightMotor2);
        public static final MotorControllerGroup leftMotorsGroup = new MotorControllerGroup(leftMotor1, leftMotor2);

        public static final DifferentialDrive driveTrain = new DifferentialDrive(leftMotorsGroup,rightMotorsGroup);
    }
    static class ElevatorConstants {
        public static final DigitalInput toplimitSwitch = new DigitalInput(0);
        public static final DigitalInput bottomlimitSwitch = new DigitalInput(1);
        public static final Spark Redline = new Spark(1);
        public static final Spark Elevator = new Spark(0);
        public static final Spark Vertical_Elevator = new Spark(2);
        public static final AnalogPotentiometer Elevator_Hand = new AnalogPotentiometer(0, 180, 30);

        public static final CANSparkMax Neo = new CANSparkMax(5, CANSparkMax.MotorType.kBrushless);
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
    static class PhotonVisionConstants {
        public static PhotonCamera camera = new PhotonCamera("IMX219");
        public static final double CAMERA_HEIGHT_METERS = Units.inchesToMeters(1/4);
        public static final double TARGET_HEIGHT_METERS = Units.inchesToMeters(15.13);
        public static final double CAMERA_PITCH_RADIANS = Units.degreesToRadians(27);
        public static PIDController fowardController = new PIDController(0.1, 0, 0);
        public static PIDController turnController = new PIDController(0.1, 0, 0);
    }
}
