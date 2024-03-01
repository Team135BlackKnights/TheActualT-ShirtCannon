package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.cannonSub;

public class fireBarrel extends Command {
    cannonSub subsystem;
    double barrelFired;
    public fireBarrel(cannonSub subsystem, double barrelFired){
        this.subsystem = subsystem;
        this.barrelFired = barrelFired;
        addRequirements(subsystem);
    }
    @Override 
    public void initialize(){

    }
    @Override
    public void execute(){
        if (barrelFired == 1){ 
            cannonSub.bar1.set(true);
            cannonSub.bar2.set(false);
            cannonSub.bar3.set(false);
            cannonSub.pressureBar.set(false);
          //middle barrelFired
          }
          //else if((RobotContainer.controller1.getAButton()==true) && (Math.abs(RobotContainer.controller1.getRightTrigger()) > 0.1)&&(Math.abs(RobotContainer.controller1.getLeftTrigger()) > 0.1)){
          //else if((RobotContainer.controller1.getAButton()==true )&& (RobotContainer.controller1.getRightBumper() == true) && (RobotContainer.controller1.getLeftBumper() == true) ){
            else if(barrelFired == 2){
            cannonSub.bar1.set(false);
            cannonSub.bar2.set(true);
            cannonSub.bar3.set(false);
            cannonSub.pressureBar.set(false);
          }
          //right barrelFired
          //else if((RobotContainer.controller1.getBButton()==true) && (Math.abs(RobotContainer.controller1.getRightTrigger()) > 0.1)&&(Math.abs(RobotContainer.controller1.getLeftTrigger()) > 0.1)){
          //else if((RobotContainer.controller1.getBButton()==true )&& (RobotContainer.controller1.getRightBumper() == true)&& (RobotContainer.controller1.getLeftBumper() == true)  ){
          else if (barrelFired == 3){ 
            cannonSub.bar1.set(false);
            cannonSub.bar2.set(false);
            cannonSub.bar3.set(true);
            cannonSub.pressureBar.set(false);
          }
          /*else if((RobotContainer.controller1.getYButton()==true )&& (RobotContainer.controller1.getRightBumper() == true)&& (RobotContainer.controller1.getLeftBumper() == true)  ){
            
            cannonSub.bar1.set(false);
            cannonSub.bar2.set(false);
            cannonSub.bar3.set(false);
            cannonSub.pressureBar.set(true);
          }*/
          //safeties not pressed
          else{
            cannonSub.bar1.set(false);
            cannonSub.bar2.set(false);
            cannonSub.bar3.set(false);
            cannonSub.pressureBar.set(false);
          }
        }
       @Override
       public void end(boolean interrupted){
        cannonSub.bar1.set(false);
            cannonSub.bar2.set(false);
            cannonSub.bar3.set(false);
            cannonSub.pressureBar.set(false);
       }
    }

