// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */

  //MY CHANGES ARE BELOW
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  private RobotContainer m_robotContainer;
  //declaring the lights
  //private AddressableLED m_led;
  //declaring the amount of leds on the led strip (example is 60)
  //private  AddressableLEDBuffer m_LedBuffer;
  //IDK why this is needed (apparently its to store the last hue of the first pixel)
  //private int m_rainbowMakerPixelStorage;


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.

    m_robotContainer = new RobotContainer();
  
      AddressableLED leftLeds = new AddressableLED(0);
        AddressableLEDBuffer leftBuffer = new AddressableLEDBuffer(41);
       // AddressableLEDBuffer rightBuffer = new AddressableLEDBuffer(39);
       //AddressableLED rightLeds = new AddressableLED(9);
          m_robotContainer = new RobotContainer();
          leftLeds.setLength(leftBuffer.getLength());
          //rightLeds.setLength(rightBuffer.getLength());
          leftLeds.start();
          //rightLeds.start();
          for (var i = 0; i < leftBuffer.getLength(); i++ ) {
            leftBuffer.setRGB(i,255,204,0);
            
          }
         // for (var i = 0; i < rightBuffer.getLength(); i++ ) {
          //  rightBuffer.setRGB(i,255,204,0);
            
          
         leftLeds.setData(leftBuffer);
         //rightLeds.setData(leftBuffer);
         leftLeds.close();
         //rightLeds.close();
        
  }


  //MORE OF MY CHANGES
  
  //private void testing() {
     // for (var i=0; i< m_LedBuffer.getLength(); i++){
        
       // final var hue = (m_rainbowMakerPixelStorage + (i*180/m_LedBuffer.getLength()))%180;
      // m_LedBuffer.setHSV(i, hue, 255, 255);
         
       // m_LedBuffer.setRGB(i, 255, 255, 204);
     // }
      
      //m_rainbowMakerPixelStorage+=3;
      //m_rainbowMakerPixelStorage %=180;
  
  
  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    //ALSO MY CHANGES
    //testing();
    //m_led.setData(m_LedBuffer);


    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
