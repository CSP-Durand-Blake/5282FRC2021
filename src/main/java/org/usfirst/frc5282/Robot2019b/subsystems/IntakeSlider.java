/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5282.Robot2019b.subsystems;

import org.usfirst.frc5282.Robot2019b.Robot;
import org.usfirst.frc5282.Robot2019b.commands.SliderMove;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
//imports for the speed controller Tallons -Jordan; posdion






  public class IntakeSlider extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  // classify things ussing private, public, static
 
 private Spark slider;
 
 
 // private static final double deadbandslider = 0.02; 
  

 

  public IntakeSlider() {
    //identify new things here Blank =  new Blank
    
    slider = new Spark(2);
    slider.setInverted(true);
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
   setDefaultCommand(new SliderMove());
   
    
  }
  
  public void SliderPower(double Z){
    if (Z>=1){            // Max input is 1.0 to -1.0.
      Z=1;
      }
  else if (Z<=-1){
      Z=-1;
  }
  
  slider.set(Z);
  }
  
  public void SliderOn(){
  //double XRightjoystick = .25* Robot.oi.xbox2.getRawAxis(5);
  double Xleftjoystick = .3* Robot.oi.xbox2.getRawAxis(1);
  SliderPower(Xleftjoystick);
  
  }

  public void SliderAuto(){
    //double XRightjoystick = .25* Robot.oi.xbox2.getRawAxis(5);
    
    SliderPower(-.32);
    
    }


  
}
  
  