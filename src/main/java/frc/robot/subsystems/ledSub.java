package frc.robot.subsystems;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ledConstants;

public class ledSub extends SubsystemBase {
    public static int InitialLoopValue;
    public static AddressableLED led;
    public static int runCommand;
    static AddressableLEDBuffer ledBuffer;
    public ledSub(){
        InitialLoopValue = 0;
        led = new AddressableLED(ledConstants.ledPort);
        ledBuffer = new AddressableLEDBuffer(ledConstants.ledLength);
        led.setLength(ledBuffer.getLength());
        led.start();
        for (var i = 0; i < ledConstants.sinePeriod; i++){
            ledConstants.ledSineStates[i] = (int)Math.floor(Math.abs(Math.sin(((i*Math.PI/16))))*255);
        }
    }
    @Override
    public void periodic(){
        runCommand +=1;
        runCommand %= 3;
        if (runCommand == 0){
            setColorWave(ledConstants.goldHSV);
        }
    }

    
  
    public static void setColorWave(int[]colorHSV){//value is basically how dark it is, is controlled by the wave function
            
        for (var i = 0; i < ledBuffer.getLength(); i++) {
            /*The line of code below essentially just takes the number of the LED then multiplies it by pi divided by a variable that can be toggled to change wave size (sine is used because it oscillates). 
            To prevent a negative number from happening (as value only takes arguments in the range 0-255) and then rounds it down to ensure that the value outputted is an integer since this function only
            accepts integers (rounds down to prevent 256 from outputting). To get it to move, we use a loop value as a way to offset it.*/ 
            final int value = ledConstants.ledSineStates[(i+InitialLoopValue)%ledConstants.sinePeriod]; //Tweak sine period to make the gradient more gentle or sharp (more is more gentle)
            // Set the value
            ledBuffer.setHSV(i, colorHSV[0], colorHSV[1], value);
        }
        InitialLoopValue += 1;
        InitialLoopValue %= ledConstants.sinePeriod;
            
    
        //sets data to buffer
        led.setData(ledBuffer);
        
        }
}