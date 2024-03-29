package frc.robot.commands;
import frc.robot.RobotContainer;
import frc.robot.subsystems.cannonSub;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class cannonComm extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final cannonSub cannonSub;
  public boolean[] solenoidStates = new boolean[]{false,false,false,false};
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
    SmartDashboard.putNumber("Desired Fire Pressure", frc.robot.subsystems.cannonSub.desPressure);

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

    /* if (!cannonSub.pressureBar.get() && RobotContainer.controller1.getRightTriggerAxis() > 0.1) {
      cannonSub.pressureBar.set(true);
    } else if (RobotContainer.controller1.getLeftTriggerAxis() > 0.1) {
      cannonSub.pressureBar.set(false);
    } */
    
    //left barrel
    //if((RobotContainer.controller1.getXButton()==true) && (Math.abs(RobotContainer.controller1.getRightTrigger()) > 0.1)&&(Math.abs(RobotContainer.controller1.getLeftTrigger()) > 0.1)){
    
    if (RobotContainer.controller1.getLeftBumper() && RobotContainer.controller1.getRightBumper()){
      
      if (RobotContainer.controller1.getXButton()){
        
        //middle barrel
        solenoidStates[0] = true;
      }
      else if (RobotContainer.controller1.getAButton()){
        
        //right barrel
        solenoidStates[1] = true;
      }
      else if (RobotContainer.controller1.getBButton()){
        
        //left barrel (i think)
        solenoidStates[2] = true;
      }
      else if (RobotContainer.controller1.getYButton()){
        
        //some 4th solenoid that hasn't been added yet
        solenoidStates[3] = true;
      }
    }
    else{
      solenoidStates = new boolean[]{false,false,false,false};
    }
    frc.robot.subsystems.cannonSub.setSolenoids(solenoidStates);
  }
    
    /*if((RobotContainer.controller1.getXButton()==true) && (RobotContainer.controller1.getRightBumper() == true)&&(RobotContainer.controller1.getLeftBumper() == true)){
      cannonSub.bar1.set(true);
      cannonSub.bar2.set(false);
      cannonSub.bar3.set(false);
      cannonSub.pressureBar.set(false);
    //middle barrel
    }
    //else if((RobotContainer.controller1.getAButton()==true) && (Math.abs(RobotContainer.controller1.getRightTrigger()) > 0.1)&&(Math.abs(RobotContainer.controller1.getLeftTrigger()) > 0.1)){
    else if((RobotContainer.controller1.getAButton()==true )&& (RobotContainer.controller1.getRightBumper() == true) && (RobotContainer.controller1.getLeftBumper() == true) ){
      cannonSub.bar1.set(false);
      cannonSub.bar2.set(true);
      cannonSub.bar3.set(false);
      cannonSub.pressureBar.set(false);
    }
    //right barrel
    //else if((RobotContainer.controller1.getBButton()==true) && (Math.abs(RobotContainer.controller1.getRightTrigger()) > 0.1)&&(Math.abs(RobotContainer.controller1.getLeftTrigger()) > 0.1)){
    else if((RobotContainer.controller1.getBButton()==true )&& (RobotContainer.controller1.getRightBumper() == true)&& (RobotContainer.controller1.getLeftBumper() == true)  ){
      cannonSub.bar1.set(false);
      cannonSub.bar2.set(false);
      cannonSub.bar3.set(true);
      cannonSub.pressureBar.set(false);
    }
    else if((RobotContainer.controller1.getYButton()==true )&& (RobotContainer.controller1.getRightBumper() == true)&& (RobotContainer.controller1.getLeftBumper() == true)  ){
      cannonSub.bar1.set(false);
      cannonSub.bar2.set(false);
      cannonSub.bar3.set(false);
      cannonSub.pressureBar.set(true);
    }
    //safeties not pressed
    else{
      cannonSub.bar1.set(false);
      cannonSub.bar2.set(false);
      cannonSub.bar3.set(false);
      cannonSub.pressureBar.set(false);
    }
  }
*/
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}