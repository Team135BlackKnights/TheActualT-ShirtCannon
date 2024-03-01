// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.RobotContainer;
import frc.robot.subsystems.driveSub;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class driveCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final driveSub driveSub;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public driveCommand(driveSub subsystem) {
    driveSub = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double left = RobotContainer.controller1.getLeftY();
    double right = RobotContainer.controller1.getRightY();
    driveSub.tankDrive(-left, -right);
  }

  
}
