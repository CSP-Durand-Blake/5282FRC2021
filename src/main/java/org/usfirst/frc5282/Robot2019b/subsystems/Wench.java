/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5282.Robot2019b.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

import org.usfirst.frc5282.Robot2019b.Robot;

import org.usfirst.frc5282.Robot2019b.commands.WenchOn;

/**
 * Add your docs here.
 */
public class Wench extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private TalonSRX wench;

  private boolean WhiteB1 = false;
  private boolean WhiteB2= false;
  private boolean WhiteB3= false;

  public void Wench(){
    wench = new TalonSRX(8);
  } 

    public void WenchUp() {
      WenchPower(.5);
    }
    
    private void WenchPower(double w) {
     //% wench.set(ControlMode.PercentOutput, w, DemandType.ArbitraryFeedForward, 0);
  }

  public void WenchDown() {
      WenchPower(-.5);
    }
    
    private void WenchStop(){
      WenchPower(0);
    }
    
      public void WenchOn(){
         WhiteB1 = Robot.oi.buttonboard.getRawButton(1);
         WhiteB2 = Robot.oi.buttonboard.getRawButton(2);
         WhiteB3 = Robot.oi.buttonboard.getRawButton(3);
        
         if((WhiteB1&&WhiteB2)||(!WhiteB1&&!WhiteB2)){
          WenchStop();
         }
         else
         {
          if(WhiteB1){
            WenchUp();
          }
          if(WhiteB2){
            WenchDown();
          }
         }
        }    

  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new WenchOn());
  }


}
