/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5282.Robot2019b.commands;

import org.usfirst.frc5282.Robot2019b.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoCurved extends Command {

  double myStartTime;
double myTime;
boolean myAutonFinished = false;
  public AutoCurved() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.driveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    myStartTime = System.currentTimeMillis();
    System.out.println("myStartTime "+myStartTime);
     myTime = 0.0;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
  myTime = (System.currentTimeMillis()-myStartTime)/1000;
  System.out.println("myTime "+myTime);
  if ((myTime>=0.0)&&(myTime<2.0)) { System.out.println("Stage 3");
   Robot.driveTrain.TargetAdjustAuto();
}
if ((myTime>=2.0)&&(myTime<6.0)) { System.out.println("Stage 4");
    Robot.rotator.RotateAuto();
}
if ((myTime>=2.5)&&(myTime<6.0)) { System.out.println("Stage 5");
    Robot.fire.FireAuto();
}
if ((myTime>=3.0)&&(myTime<6.0)) { System.out.println("Stage 6");
  Robot.barrel.BarrelOnAuto();
  if ((myTime>=6.0)&&(myTime<8.0)) { System.out.println("Stage 1");
    Robot.driveTrain.ApplyMotorPower(-.35, -.35);
}
  if ((myTime>=8.0)&&(myTime<=10)) { System.out.println("Stage 2");
  Robot.driveTrain.ApplyMotorPower(0, 0);
  }
  if ((myTime>=10)) { myAutonFinished = true;}
}
  }

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
