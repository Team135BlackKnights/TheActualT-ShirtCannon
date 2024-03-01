package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ledSub;

public class setColorWave extends Command {
    ledSub leds;
    double offset;
    double InitialLoopValue;
    public setColorWave(ledSub subsystem){
        this.leds = subsystem;
        addRequirements(subsystem);
    }    
    @Override 
    public void initialize(){
        InitialLoopValue = 0;
    }
    @Override
    public void execute(){
        ledSub.setColorWave(23,255,InitialLoopValue);
        // Increase the value computed in the sine function by pi/(the changable period) to make the gradient "move"
        InitialLoopValue += Math.PI/16; //offset by one "notch" each time
        
        //Check bounds
        InitialLoopValue %=2*Math.PI;
    }
}
