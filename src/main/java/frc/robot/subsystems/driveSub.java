// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class driveSub extends SubsystemBase {

  //Drive Motors
  public final static WPI_TalonSRX frontLeft = new WPI_TalonSRX(Constants.FRONT_LEFT_MOTOR);
  public final static WPI_TalonSRX backLeft = new WPI_TalonSRX(Constants.BACK_LEFT_MOTOR);
  public final static WPI_TalonSRX frontRight = new WPI_TalonSRX(Constants.FRONT_RIGHT_MOTOR);
  public final static WPI_TalonSRX backRight = new WPI_TalonSRX(Constants.BACK_RIGHT_MOTOR);
  

  

  DifferentialDrive tankDrive = new DifferentialDrive(frontLeft, frontRight);

  /** Creates a new ExampleSubsystem. */
  public driveSub() {
    backLeft.set(ControlMode.Follower,0);
    backLeft.follow(frontLeft, FollowerType.PercentOutput);
    backRight.set(ControlMode.Follower, 0);
    backRight.follow(frontRight, FollowerType.PercentOutput);
  }

  public void tankDrive(double left, double right){
    tankDrive.tankDrive(left, right);
  }

}
