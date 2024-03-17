package frc.robot.commands;
import frc.robot.subsystems.ledSub;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ledConstants;

public class ledSpinUp extends Command{

    private static final boolean isFinished = false;
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
        
       for (var i = 0; i < ledConstants.ledLength; i++){
        if(i < (offset+ledConstants.chargeUpLength) && i > (offset-ledConstants.chargeUpLength) ){
            ledSub.ledBuffer.setHSV(i, ledConstants.goldHSV[0], ledConstants.goldHSV[1], ledConstants.goldHSV[2]);
        }
        else{
            ledSub.ledBuffer.setHSV(i, 0, 0, 0);
        }
       }
       offset +=1;
       offset %= ledConstants.ledLength;
       ledSub.led.setData(ledSub.ledBuffer);
       if (offset == 0){
        isFinished();
       }
    }
    @Override 
    public void end(boolean interrupted){
        length = 5;
        offset = 0;
        sleepDivisor = 1;
        timesRan = 0;
    }
    @Override 
    public boolean isFinished(){
    return isFinished;
}
}
