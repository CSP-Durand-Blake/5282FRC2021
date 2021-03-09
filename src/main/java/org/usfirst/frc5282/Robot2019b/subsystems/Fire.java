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
import org.usfirst.frc5282.Robot2019b.commands.FireBall;
/**
 * Add your docs here.
 */
public class Fire extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private TalonSRX fire;
  private VictorSPX fire2;

  private static final double deadbandfire = 0.02; 



  public Fire(){
    fire =  new TalonSRX(5);
    fire2 = new VictorSPX(0);
    fire.setInverted(false);
    fire2.setInverted(false);
    fire.configNeutralDeadband(deadbandfire);
    fire2.follow(fire);

  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new FireBall()); 
  }

  public void FirePower(double F) {                    // Tankdrive   
    fire.set(ControlMode.PercentOutput, F,DemandType.ArbitraryFeedForward, 0);
    fire2.set(ControlMode.PercentOutput, F,DemandType.ArbitraryFeedForward, 0);
  }

  public void Ballfire(){
    double rTrigger = 1.0 * Robot.oi.xbox2.getRawAxis(3);
  
    FirePower(rTrigger); 
  }

  public void FireAuto65(){
    FirePower(.67);

  }

  public void FireAuto(){
    FirePower(.7);
    
    
    }

    public void FireAuto75(){
      FirePower(.7);
    }

    public void FireAuto100(){
      FirePower(1);
      
      
      }

      public void greenzone(){
        Robot.fire.FireAuto100();
        Robot.barrel.BarrelOnAuto();

      }

      public void yellowzone(){
        Robot.rotator.RotateAuto35();
    Robot.fire.FireAuto();
   //Robot.barrel.BarrelOnAuto();
      }

      public void Bluezone(){
        Robot.rotator.RotateAuto34();
    Robot.fire.FireAuto65();
  // Robot.barrel.BarrelOnAuto();
      }
    
      public void Redzone(){
        Robot.rotator.RotateAuto38();
        Robot.fire.FireAuto65();
        //Robot.barrel.BarrelOnAuto();
      }

     
}
