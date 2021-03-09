

package org.usfirst.frc5282.Robot2019b.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5282.Robot2019b.Robot;

/**
 *
 */

public class DriveWithXbox extends Command {

  
    public DriveWithXbox() {

 
        requires(Robot.driveTrain);
        

    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
 protected void execute() {
        Robot.driveTrain.DriveWithXbox();}

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
