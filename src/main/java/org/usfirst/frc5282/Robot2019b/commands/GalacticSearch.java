// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.usfirst.frc5282.Robot2019b.commands;

import org.usfirst.frc5282.Robot2019b.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GalacticSearch extends Command {

  double myStartTime;
  double myTime;
  boolean myAutonFinished = false;

  public GalacticSearch() {
    // Use requires() here to declare subsystem dependencies
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
    if((myTime>=0.0)&&(myTime<1)){
      System.out.println("Stage 1");
      Robot.intakeSlider.SliderAuto();
     
    }
    if((myTime>=1.1)&&(myTime<2)){
      System.out.println("Stage 2");
       Robot.driveTrain.ApplyMotorPower(-.4, -.4);
      //Robot.intake.AutoFeedball();
    }
    if((myTime>=2.1)&&(myTime<2.5)){
      System.out.println("Stage 3");
      Robot.driveTrain.ApplyMotorPower(0, 0);
      Robot.intake.AutoFeedball();
     
    }
    if((myTime>=2.6)&&(myTime<2.9)){
      System.out.println("Stage 4");
      Robot.barrel.BarrelOnAuto();
    }
    if((myTime>=3.0)&&(myTime<3.3)){
      System.out.println("Stage 4");
      Robot.driveTrain.ApplyMotorPower(-.4, -.4);
    }
    /*
    if((myTime>=3.4)&&(myTime<3.9)){
      Robot.driveTrain.ApplyMotorPower(0, -.35);
    }*/
    if((myTime>=3.4)&&(myTime<3.5)){
      System.out.println("Stage 5");
     Robot.driveTrain.ApplyMotorPower(0, 0);
    }
    
    if((myTime>=3.6)&&(myTime<4.4)){
      System.out.println("Stage 6");
      Robot.intake.AutoFeedball();
      Robot.barrel.BarrelOnAuto();
    }
    if((myTime>=4.5)&&(myTime<7.5)){
      System.out.println("Stage 7");
      Robot.driveTrain.ApplyMotorPower(-9,.3 );
    }
    if((myTime>=7.6)&&(myTime<7.7)){
      System.out.println("Stage 8");
      Robot.driveTrain.ApplyMotorPower(0,0 );
    }
    if((myTime>=7.8)&&(myTime<8.3)){
      System.out.println("Stage 8");
      Robot.driveTrain.ApplyMotorPower(-.3,-.3 );
    }
    if((myTime>=8.4)&&(myTime<8.5)){
      System.out.println("Stage 8");
      Robot.driveTrain.ApplyMotorPower(0,0 );
    }
    if((myTime>=8.6)&&(myTime<9.5)){
      System.out.println("Stage 6");
      Robot.intake.AutoFeedball();
      Robot.barrel.BarrelOnAuto();
    }
    if((myTime>=9.6)&&(myTime<10.7)){
      System.out.println("Stage 8");
      Robot.driveTrain.ApplyMotorPower(8,-.3 );
    }
    if((myTime>=10.8)&&(myTime<10.9)){
      System.out.println("Stage 8");
      Robot.driveTrain.ApplyMotorPower(0,0 );
    }
    if((myTime>=11)&&(myTime<14)){
      System.out.println("Stage 8");
      Robot.driveTrain.ApplyMotorPower(.4, .4);
      
    }
    if((myTime>=14.1)&&(myTime<14.2)){
      System.out.println("Stage 8");
      Robot.driveTrain.ApplyMotorPower(0, 0);
      
    }
    if((myTime>=14.3)&&(myTime<15)){
      System.out.println("Stage 8");
      Robot.fire.greenzone();
      
    }
  }


  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {}

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {}
}
