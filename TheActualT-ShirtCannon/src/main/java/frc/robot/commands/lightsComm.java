// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class lightsComm extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  

  

  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void initialize() {
    //declaring the lights
    AddressableLED m_led = new AddressableLED(Constants.LED_STRIP);
    //declaring the amount of leds on the led strip (example is 60)
    AddressableLEDBuffer m_LedBuffer = new AddressableLEDBuffer(60);
    m_led.setLength(m_LedBuffer.getLength());
    //set the data and start the leds
    m_led.setData(m_LedBuffer);
    m_led.start();
  }

  
}
