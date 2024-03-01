// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Timer;

public class cannonSub extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public cannonSub() {}
  Timer timer = new Timer();
  public double commandSecondsOpen = .2;
  public int desPressure = 100;
 
  //solonoid declaration  
  public Solenoid bar1 = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.LEFT_BARREL);
  public Solenoid bar2 = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.MIDDLE_BARREL);
  public Solenoid bar3 = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.RIGHT_BARREL);
  public Solenoid pressureBar = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.PRESSURE_CONTROL);
  public WPI_TalonSRX arm = new WPI_TalonSRX(Constants.ARM_MOTOR);

  /**
   * Example command factory method.
   *
   * @return a command
   */


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
  /**
   * Takes in an array with 4 booleans, with each boolean representing whether a solenoid is on (true) or off (false). Intended to be used with controller input
   * @param solenoidStates
   * The array containing the state of each solenoid (0 is middle, 1 is right, 2 is left, 3 is the pressure bar)
   */
  public void setSolenoids(boolean[] solenoidStates){
    bar1.set(solenoidStates[0]);
      bar2.set(solenoidStates[1]);
      bar3.set(solenoidStates[2]);
      pressureBar.set(solenoidStates[3]);
  }

  /**
   * Similar to setSolenoids, but automatically closes the solenoids after a set time. Designed to be called as an instantCommand
   * @param solenoidStates
   */
  public void fireSolenoids(boolean[] solenoidStates){
    timer.stop();
    timer.reset();
    timer.start();
    setSolenoids(solenoidStates);
    if (timer.hasElapsed(commandSecondsOpen)){
      setSolenoids(new boolean[]{false,false,false,false});
    }
  }
    public Command fireSolenoidCommand(boolean[]solenoidStates) {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          this.fireSolenoids(solenoidStates);
        });
  }
  
}
