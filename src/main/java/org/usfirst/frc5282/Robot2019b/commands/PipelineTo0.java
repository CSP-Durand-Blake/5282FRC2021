
package org.usfirst.frc5282.Robot2019b.commands;
import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc5282.Robot2019b.LimeLight;

/**
 *  
 */
public class PipelineTo0 extends InstantCommand {
  
  LimeLight lime;

  /**
   * Command changes limelight to pipeline 0
   */
  public PipelineTo0() {
    //requires();

  }
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
protected void execute() {
  lime.setPipeline(0);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
      return false;
  }
  @Override
  protected void end() {
  }
 
    //lime.setPipeline(1);
   
  

}
