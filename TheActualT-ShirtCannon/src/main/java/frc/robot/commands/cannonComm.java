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
    if((RobotContainer.controller1.getLeftBumper() == true) && (RobotContainer.controller1.getRightBumper() == true)&&(RobotContainer.controller1.getBButton()==true)){
      cannonSub.bar1.set(true);
      bar3.set(false);
      bar5.set(false);

    }
    //barrel 3
    else if((RobotContainer.controller1.getXButton()==true )&& (RobotContainer.controller1.getRightBumper() == true) && (RobotContainer.controller1.getLeftBumper() == true) ){
      bar1.set(false);
      bar3.set(true);
      bar5.set(false);
    }
    //barrel 1
    else if((RobotContainer.controller1.getAButton()==true )&& (RobotContainer.controller1.getRightBumper() == true)&& (RobotContainer.controller1.getLeftBumper() == true)  ){
      bar1.set(false);
      bar3.set(false);
      bar5.set(true);
    }
    else{
      bar1.set(false);
      bar2.set(false);
      bar3.set(false);
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
