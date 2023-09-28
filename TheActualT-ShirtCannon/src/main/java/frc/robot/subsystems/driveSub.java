// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;


public class driveSub extends SubsystemBase {
//LED Strip
  public final AddressableLED leftLeds = new AddressableLED(1);
  public final AddressableLEDBuffer leftBuffer = new AddressableLEDBuffer(39);
  public final AddressableLED rightLeds = new AddressableLED(9);
  
  //Drive Motors
  public final WPI_TalonSRX frontLeft = new WPI_TalonSRX(Constants.FRONT_LEFT_MOTOR);
  public final WPI_TalonSRX backLeft = new WPI_TalonSRX(Constants.BACK_LEFT_MOTOR);
  public final WPI_TalonSRX frontRight = new WPI_TalonSRX(Constants.FRONT_RIGHT_MOTOR);
  public final WPI_TalonSRX backRight = new WPI_TalonSRX(Constants.BACK_RIGHT_MOTOR);
  
  MotorControllerGroup leftSide = new MotorControllerGroup(frontLeft, backLeft);
  MotorControllerGroup rightSide = new MotorControllerGroup(frontRight, backRight);

  DifferentialDrive tankDrive = new DifferentialDrive(leftSide, rightSide);

  /** Creates a new ExampleSubsystem. */
  public driveSub() {
    leftLeds.setLength(leftBuffer.getLength());
    leftSide.setInverted(true);
    for (var i = 0; i < leftBuffer.getLength(); i++ ) {
      leftBuffer.setRGB(i,255,204,0);
      
    }
  leftLeds.setData(leftBuffer);
  rightLeds.setData(leftBuffer);
  }


  public void tankDrive(double left, double right){
    tankDrive.tankDrive(left, right);
  }

}
