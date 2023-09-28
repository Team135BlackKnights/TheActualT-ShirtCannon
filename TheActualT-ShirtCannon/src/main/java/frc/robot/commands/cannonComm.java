// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.RobotContainer;
import frc.robot.subsystems.cannonSub;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class cannonComm extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final cannonSub cannonSub;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public cannonComm(cannonSub subsystem) {
    cannonSub = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //moving the arm
    if((RobotContainer.controller1.getPOV()) == 0){

      cannonSub.arm.set(-.75);
    }
    
    else if(RobotContainer.controller1.getPOV() ==180 )
    {
      cannonSub.arm.set(.75);
    }
    else{
      cannonSub.arm.set(0);
    }
    //left barrel
    if((RobotContainer.controller1.getXButton()==true) && (RobotContainer.controller1.getRightBumper() == true)&&(RobotContainer.controller1.getLeftBumper() == true)){
      cannonSub.bar1.set(true);
      cannonSub.bar2.set(false);
      cannonSub.bar3.set(false);
      cannonSub.pressureRelease.set(false);
    //middle barrel
    }
    else if((RobotContainer.controller1.getAButton()==true )&& (RobotContainer.controller1.getRightBumper() == true) && (RobotContainer.controller1.getLeftBumper() == true) ){
      cannonSub.bar1.set(false);
      cannonSub.bar2.set(true);
      cannonSub.bar3.set(false);
      cannonSub.pressureRelease.set(false);
    }
    //right barrel
    else if((RobotContainer.controller1.getBButton()==true )&& (RobotContainer.controller1.getRightBumper() == true)&& (RobotContainer.controller1.getLeftBumper() == true)  ){
      cannonSub.bar1.set(false);
      cannonSub.bar2.set(false);
      cannonSub.bar3.set(true);
      cannonSub.pressureRelease.set(false);
    }
    //safties not pressed
    else{
      cannonSub.bar1.set(false);
      cannonSub.bar2.set(false);
      cannonSub.bar3.set(false);
      cannonSub.pressureRelease.set(true);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
