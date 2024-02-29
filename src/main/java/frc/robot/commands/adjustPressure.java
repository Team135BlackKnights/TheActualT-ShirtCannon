package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.cannonSub;

public class adjustPressure extends Command {
    private final cannonSub cannonSub;
    private boolean isFinished = false;
    private int adj;
    public adjustPressure(cannonSub subsystem, int adjustment) {
        adj = adjustment;
        cannonSub = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        isFinished = false;
        cannonSub.desPressure += adj;
        isFinished = true;
    }

    @Override
    public void execute() {
        
    }

    @Override
    public void end(boolean interrupted) {
        
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
