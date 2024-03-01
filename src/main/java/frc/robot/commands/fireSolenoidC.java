package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.cannonSub;


public class fireSolenoidC extends Command {
    cannonSub subsystem;
    boolean[] solenoidStates;
    public fireSolenoidC (cannonSub subsystem, boolean[] solenoidStates){
        this.subsystem = subsystem;
        this.solenoidStates = solenoidStates;
        addRequirements(subsystem);
    }
    @Override 
    public void initialize(){

    }
    @Override 
    public void execute(){
        cannonSub.fireSolenoids(solenoidStates);
    }
    @Override
    public void end(boolean interrupted){
        cannonSub.fireSolenoids(new boolean[]{false,false,false,false});
    }
}
