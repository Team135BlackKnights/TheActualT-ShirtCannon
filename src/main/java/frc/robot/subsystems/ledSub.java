package frc.robot.subsystems;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ledConstants;
public class ledSub extends SubsystemBase {
    double InitialLoopValue;
    AddressableLED led;
    AddressableLEDBuffer ledBuffer;
    public ledSub(){
        InitialLoopValue = 0;
        led = new AddressableLED(ledConstants.ledPort);
        ledBuffer = new AddressableLEDBuffer(ledConstants.ledLength);
        led.setLength(ledBuffer.getLength());
    }
    public void setColorWave(int h, int s, double sinePeriod){//value is basically how dark it is, is controlled by the wave function
        Thread updateThread = new Thread(
        () -> {

            for (var i = 0; i < ledBuffer.getLength(); i++) {
                /*The line of code below essentially just takes the number of the LED then multiplies it by pi divided by a variable that can be toggled to change wave size (sine is used because it oscillates). 
                To prevent a negative number from happening (as value only takes arguments in the range 0-255) and then rounds it down to ensure that the value outputted is an integer since this function only
                accepts integers (rounds down to prevent 256 from outputting). To get it to move, we use a loop value as a way to offset it.*/ 
                final int value = (int)Math.floor(Math.abs(Math.sin(((i*Math.PI/sinePeriod)+InitialLoopValue)))*255); //Tweak sine period to make the gradient more gentle or sharp (more is more gentle)
                // Set the value
                ledBuffer.setHSV(i, h, s, value);
            
        }
        
            // Increase the value computed in the sine function by pi/(the changable period) to make the gradient "move"
            InitialLoopValue += Math.PI/sinePeriod; //offset by one "notch" each time
        
            //Check bounds
            InitialLoopValue %=2*Math.PI;
    
            //sets data to buffer
            led.setData(ledBuffer);
        });
        updateThread.setDaemon(true);
        updateThread.run();
        }
    }

