package frc.robot.commands;
import frc.robot.subsystems.ledSub;
import edu.wpi.first.wpilibj2.command.Command;

public class ledSpinUp extends Command{

    ledSub subsystem;
    int offset;
    int length;
    long sleepDivisor;
    int timesRan;
    int[] hsv = new int[]{23,255,83};
    public ledSpinUp(ledSub subsystem){
    
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }
    
    @Override
    public void initialize(){
        
        length = 5; //NOTE: We can change this
        offset = 0;
        sleepDivisor = 1;
        timesRan = 0;
    }

    @Override
    public void execute(){
       
    }
    @Override 
    public void end(boolean interrupted){
        length = 5;
        offset = 0;
        sleepDivisor = 1;
        timesRan = 0;
    }

}
