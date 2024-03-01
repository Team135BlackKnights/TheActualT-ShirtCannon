package frc.robot.commands;
import frc.robot.subsystems.ledSub;
import edu.wpi.first.wpilibj2.command.Command;

public class ledSpinUp extends Command{

    ledSub subsystem;
    int timesRun;
    int length;

    public ledSpinUp(ledSub subsystem){
    
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }
    
    @Override
    public void initialize(){
        
        length = 5; //NOTE: We can change this
        timesRun = 0;
    }

    @Override
    public void execute(){

        
    }

}
