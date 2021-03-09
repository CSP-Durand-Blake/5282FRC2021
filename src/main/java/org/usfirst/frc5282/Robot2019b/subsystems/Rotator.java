/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5282.Robot2019b.subsystems;
import org.usfirst.frc5282.Robot2019b.Robot;
import org.usfirst.frc5282.Robot2019b.commands.RotateFire;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;

/**
 * Add your docs here.
 */
public class Rotator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
 private Spark Rotator;

 private static final double deadbandrotator = 0.02;   


public Rotator(){
Rotator = new Spark(1);
Rotator.setInverted(false);


}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new RotateFire());
  }

public void RotatorPower(double R){
  if (R>=1){            // Max input is 1.0 to -1.0.
    R=1;
    }
else if (R<=-1){
    R=-1;
}

Rotator.set(R);
}

public void Rotate(){
//double Xleftjoystick = .3* Robot.oi.xbox2.getRawAxis(1);
double XRightjoystick = -.6* Robot.oi.xbox2.getRawAxis(5);
RotatorPower(XRightjoystick);


}

public void RotateAuto(){
RotatorPower(.42);
}

public void RotateAuto34(){
  RotatorPower(.34);
}

public void RotateAuto35(){
  RotatorPower(.35);
}

public void RotateAuto38(){
  RotatorPower(.38);
}
}
