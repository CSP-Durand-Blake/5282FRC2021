
package org.usfirst.frc5282.Robot2019b.commands;
import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc5282.Robot2019b.LimeLight;

/**
 *  
 */
public class PipelineTo1 extends InstantCommand {
  
  LimeLight lime;

  /**
   * Command changes limelight to pipeline 0
   */
  public PipelineTo1() {
    //requires();

  }
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
protected void execute() {
  lime.setPipeline(1);
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
