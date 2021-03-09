// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.usfirst.frc5282.Robot2019b.commands;

import org.usfirst.frc5282.Robot2019b.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Bluezone extends Command {
  public Bluezone() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
   // requires(Robot.fire);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {}

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.fire.Bluezone();
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
