/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5282.Robot2019b.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc5282.Robot2019b.Robot;
import org.usfirst.frc5282.Robot2019b.commands.SliderMove;

import edu.wpi.first.wpilibj.Spark;

/**
 * Add your docs here.
 */
public class Slider extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Spark slider;


  public void Slider(){
    slider = new Spark(0);
    slider.setInverted(false);

  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new SliderMove());
  }

  public void SliderPower(double S){ // our variable that is applied to the power
    if(S>=1){
      S=1;
    }
    else if(S<=1){
      S=-1;
    }

    slider.set(S);
  }

public void Slide(){
  double XrightJoystick = .4* Robot.oi.xbox2.getRawAxis(0);// get Joystick axis 0 and multiply it by .4
  SliderPower(XrightJoystick);
}

}
