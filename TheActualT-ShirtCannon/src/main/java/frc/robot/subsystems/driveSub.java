// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class driveSub extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public driveSub() {}

  //Drive Motors
  WPI_TalonSRX frontLeft = new WPI_TalonSRX(Constants.FRONT_LEFT_MOTOR);
  WPI_TalonSRX backLeft = new WPI_TalonSRX(Constants.BACK_LEFT_MOTOR);
  WPI_TalonSRX frontRight = new WPI_TalonSRX(Constants.FRONT_RIGHT_MOTOR);
  WPI_TalonSRX backRight = new WPI_TalonSRX(Constants.BACK_RIGHT_MOTOR);
  
  MotorControllerGroup leftSide = new MotorControllerGroup(frontLeft, backLeft);
  MotorControllerGroup rightSide = new MotorControllerGroup(frontRight, backRight);

  DifferentialDrive tankDrive = new DifferentialDrive(leftSide, rightSide);

  public void tankDrive(double left, double right){
    tankDrive(left, right);
  }

}
