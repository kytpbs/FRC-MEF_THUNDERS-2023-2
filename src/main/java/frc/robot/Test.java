package frc.robot;

import static frc.robot.Constants.ElevatorConstants.Neo;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Test {
    static double Neo_speed;
    static PIDController pid = new PIDController(0.1, 0, 0);
    public static void neopid() {
        double neo_pos = SmartDashboard.getNumber("Neo pos", 50);
        Neo_speed = pid.calculate(Neo.getEncoder().getPosition(), neo_pos);
        Neo.set(Neo_speed);
    }
    
}
