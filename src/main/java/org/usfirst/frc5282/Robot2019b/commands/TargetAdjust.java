/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5282.Robot2019b.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5282.Robot2019b.Robot;
import org.usfirst.frc5282.Robot2019b.LimeLight;
 
import edu.wpi.first.networktables.NetworkTable;            //!! Limelight
import edu.wpi.first.networktables.NetworkTableEntry;       //!! Limelight
import edu.wpi.first.networktables.NetworkTableInstance;    //!! Limelight

 

public class TargetAdjust extends Command {

  
    public TargetAdjust() {

 
        requires(Robot.driveTrain);
        

    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
 protected void execute() {
        Robot.driveTrain.TargetAdjust();
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
        Robot.driveTrain.DriveWithXbox();
    }
}
