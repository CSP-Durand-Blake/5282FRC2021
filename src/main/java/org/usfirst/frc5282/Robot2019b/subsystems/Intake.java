/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5282.Robot2019b.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.usfirst.frc5282.Robot2019b.Robot;

import org.usfirst.frc5282.Robot2019b.commands.IntakeBall;

//imports for the speed controller Tallons -Jordan; posdion

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.Spark;

/**
 * Add your docs here.
 */
  public class Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  // classify things ussing private, public, static
    
  
  private TalonSRX intake;
 
  
 
  //private boolean lTrigger = true;
  //private boolean rTrigger = true;

  

  private static final double deadbandintake = 0.02;    
  private static final double deadbandfire = 0.02; 

  public Intake() {
    //identify new things here Blank =  new Blank
    
    intake = new TalonSRX(6);
    intake.setInverted(false);
    intake.configNeutralDeadband(deadbandintake);

    

    

/*
fire =  new TalonSRX(5);
    fire2 = new VictorSPX(0);
    fire.setInverted(false);
    fire2.setInverted(false);
    fire.configNeutralDeadband(deadbandfire);
    fire2.follow(fire);
    */
}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    
   setDefaultCommand(new IntakeBall()); //the comand that is used for this subsystem
    
  }







/*
public void FirePower(double F) {                    // Tankdrive   
  fire.set(ControlMode.PercentOutput, F,DemandType.ArbitraryFeedForward, 0);
  fire2.set(ControlMode.PercentOutput, F,DemandType.ArbitraryFeedForward, 0);
}
*/
public void IntakePower(double I){
  intake.set(ControlMode.PercentOutput, I, DemandType.ArbitraryFeedForward, 0);
}

        
 
  

  
  public void BallIntake(){
   
    double lTrigger = -.3 * Robot.oi.xbox2.getRawAxis(2);
    IntakePower(lTrigger); 


    }

    public void AutoFeedball(){
      IntakePower(-.30);

    }
    

  }