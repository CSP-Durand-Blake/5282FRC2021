
package org.usfirst.frc5282.Robot2019b.commands;

import org.usfirst.frc5282.Robot2019b.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.InstantCommand;


/**
 * Autonomus comand
 */
public class AutoInFront extends InstantCommand {

double myStartTime;
double myTime;
boolean myAutonFinished = false;

  

public AutoInFront() {
    requires(Robot.driveTrain);
    // requires(Robot.rotator);
    // requires(Robot.fire);
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
   //Robot.driveTrain.PastLine();
   
  myTime = (System.currentTimeMillis()-myStartTime)/1000;
  System.out.println("myTime "+myTime);
  if((myTime>=0.0)&&(myTime<2.1)) {System.out.println("Stage 3");
  Robot.driveTrain.ApplyMotorPower(-.35, -.35);
}
 if ((myTime>=2.1)&&(myTime<4.0)) { System.out.println("Stage 3");
   Robot.driveTrain.TargetAdjustAuto();
 }
 if ((myTime>=4.0)&&(myTime<9.0)) { System.out.println("Stage 4");
   Robot.rotator.RotateAuto();
 }
 if ((myTime>=6.0)&&(myTime<9.0)) { System.out.println("Stage 5");
     Robot.fire.FireAuto();
 }
 if ((myTime>=6.5)&&(myTime<9.5)) { System.out.println("Stage 6");
   Robot.barrel.BarrelOnAuto();
 }
  if ((myTime>=8.0)&&(myTime<=10)) { System.out.println("Stage 2");
  Robot.driveTrain.ApplyMotorPower(0, 0);
  }
  if ((myTime>=10)) { myAutonFinished = true;}
}

 
  
 
 





   //while(state<100);{
    // System.out.println("STATE WORKING");
    //startTime=System.currentTimeMillis();
    //if (System.currentTimeMillis()>startTime+3){
    /*  System.out.println("State 1 timed out.");
     
      Timer.delay(2);
      Robot.driveTrain.ApplyMotorPower(0, 0);
      Timer.delay(.5);
      Robot.driveTrain.TargetAdjustAuto();
      Timer.delay(1);
      
      Timer.delay(.5);
      Robot.rotator.RotateAuto();
      Robot.barrel.BarrelOnAuto();
      Robot.fire.Ballfire();
      Timer.delay(6);
      Robot.driveTrain.ApplyMotorPower(0, 0);
      Timer.delay(3);
*/

     
    //}
      
      
        // run for 4 seconds
/*
switch(state){
    case 0:
    s
    
    state = 1;
    break;

    case 1:
    if (System.currentTimeMillis()>startTime+10500){
      System.out.println("State 1 timed out.");
      state=2;
    }
    state = 2;
    break;

    case 2:
    Robot.driveTrain.ApplyMotorPower(-.5, -.5);
    Timer.delay(4.0);    // run for 4 seconds
    state = 3;
    break;

    case 3:
    state = 100;
    break;

    case 100:

    break;
  }
}
*/
 

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
