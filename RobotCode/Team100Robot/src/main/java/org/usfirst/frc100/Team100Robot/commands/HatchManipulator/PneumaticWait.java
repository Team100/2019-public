/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc100.Team100Robot.commands.HatchManipulator;

import org.usfirst.frc100.Team100Robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.*;

public class PneumaticWait extends Command {
  private boolean done = false;
  private double starttime = 0;
  
  public PneumaticWait() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.manipulator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    starttime = Timer.getFPGATimestamp();
    done = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    SmartDashboard.putNumber("Pneumatic Wait FPGA Timestamp",Timer.getFPGATimestamp());
    if(Timer.getFPGATimestamp() - starttime >= 0.5){
      done = true;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return done;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    System.out.println("@@@@@@@@@@@@@@@@@@@@ Pneumatic done");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
