// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class cannonSub extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public cannonSub() {}

 
  //solonoid declaration  
  Solenoid bar1 = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.LEFT_BARREL);
  Solenoid bar2 = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.MIDDLE_BARREL);
  Solenoid bar3 = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.RIGHT_BARREL);
  WPI_TalonSRX arm = new WPI_TalonSRX(Constants.ARM_MOTOR);

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
