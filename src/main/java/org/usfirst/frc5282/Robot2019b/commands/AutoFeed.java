/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5282.Robot2019b.commands;

import org.usfirst.frc5282.Robot2019b.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoFeed extends Command {

  double myStartTime;
  double myTime;
  boolean myAutonFinished = false;
  
  public AutoFeed() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.intake);
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
    if ((myTime>=0.0)&&(myTime<2)) { System.out.println("Stage 1");
    Robot.intakeSlider.SliderAuto();
  }
    if ((myTime>=2)&&(myTime<8.0)) { System.out.println("Stage 1");
    Robot.barrel.BarrelDownAuto();
    }
    if ((myTime>=1.0)&&(myTime<6.0)) { System.out.println("Stage 2");
    Robot.intake.AutoFeedball();
    }
    if ((myTime>=6.0)&&(myTime<7.0)) { System.out.println("Stage 3");
    Robot.driveTrain.ApplyMotorPower(.25, .25);
    }
    if ((myTime>=7.0)&&(myTime<9.0)) { System.out.println("Stage 4");
    Robot.driveTrain.ApplyMotorPower(-.50, .75);
    }
    if ((myTime>=9.0)&&(myTime<10.0)) {System.out.println("Stage 5");
    Robot.driveTrain.ApplyMotorPower(.25, .25);
  }
  if ((myTime>=10)) { myAutonFinished = true;}

    /*
    Robot.barrel.BarrelDownAuto();
    Robot.intake.AutoFeedball();
    Timer.delay(8);
    Robot.driveTrain.ApplyMotorPower(.25, .25);
    Timer.delay(2);
    Robot.driveTrain.TurnAuto(-.50, .50);
    */
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return myAutonFinished;
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
