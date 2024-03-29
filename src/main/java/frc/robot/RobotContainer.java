// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.cannonComm;
import frc.robot.commands.driveCommand;
import frc.robot.commands.ledSpinUp;
import frc.robot.subsystems.cannonSub;
import frc.robot.subsystems.driveSub;
import frc.robot.commands.fireSolenoidC;
import frc.robot.commands.setColorWaveC;
import frc.robot.subsystems.ledSub;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final driveSub driveSub = new driveSub();
  private final cannonSub cannonSub = new cannonSub();
  private final ledSub ledSub = new ledSub();
  private setColorWaveC setColorWave = new setColorWaveC(ledSub);
  
  //final JoystickButton rBumper = new JoystickButton(controller1, 5);
  //final JoystickButton lBumper = new JoystickButton(controller1, 6);

  // Replace with CommandPS4Controller or CommandJoystick if needed
  public static final XboxController controller1 =
      new XboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    driveSub.setDefaultCommand(new driveCommand(driveSub));
    cannonSub.setDefaultCommand(new cannonComm(cannonSub));
    ledSub.setDefaultCommand(setColorWave);
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
       
    Trigger leftBarrelTrigger = new Trigger(this::fireLeftBarrel);
    Trigger middleBarrelTrigger = new Trigger(this::fireMiddleBarrel);
    Trigger rightBarrelTrigger = new Trigger(this::fireRightBarrel);
    leftBarrelTrigger.onTrue(new SequentialCommandGroup(new ledSpinUp(ledSub), new fireSolenoidC(cannonSub, new boolean[]{true,false,false,false})));
    middleBarrelTrigger.onTrue(new SequentialCommandGroup(new ledSpinUp(ledSub), new fireSolenoidC(cannonSub, new boolean[]{false,true,false,false})));
    rightBarrelTrigger.onTrue(new SequentialCommandGroup(new ledSpinUp(ledSub), new fireSolenoidC(cannonSub, new boolean[]{true,false,false,false})));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(driveSub);
  }
  public boolean fireLeftBarrel(){
    return controller1.getRightBumper() && controller1.getLeftBumper() && controller1.getXButtonPressed();
  }
  public boolean fireMiddleBarrel(){
    return controller1.getRightBumper() && controller1.getLeftBumper() && controller1.getAButton();
  }
  public boolean fireRightBarrel(){
    return controller1.getRightBumper() && controller1.getLeftBumper() && controller1.getBButton();
  }
  
}
