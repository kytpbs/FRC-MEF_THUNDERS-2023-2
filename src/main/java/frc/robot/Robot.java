// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static frc.robot.Constants.AutoConstants.kCameraAuto;
import static frc.robot.Constants.AutoConstants.kGyroAuto;
import static frc.robot.Constants.AutoConstants.kStabilize;
import static frc.robot.Constants.AutoConstants.kTimedAuto;
import static frc.robot.Constants.DriveConstants.driveTrain;
import static frc.robot.Constants.ElevatorConstants.Elevator_Hand;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;



/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */


public class Robot extends TimedRobot {
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  private String m_autoSelected;
  

  Teleop teleop = new Teleop();
  Autonomous automonus = new Autonomous();
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Timer Auto", kTimedAuto);
    m_chooser.addOption("Gyro Auto", kGyroAuto);
    m_chooser.addOption("Camera Auto", kCameraAuto);
    m_chooser.addOption("Stabilize Auto", kStabilize);
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("Potansiyometre", Elevator_Hand.get());
  }

  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    System.out.println("Auto selected: " + m_autoSelected);
    Autonomous.init(m_autoSelected);
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    Teleop.drive();
    Teleop.elevator();
  }

  @Override
  public void disabledInit() {
    driveTrain.stopMotor();
  }

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}