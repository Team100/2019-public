/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc100.Team100Robot.commands.Elevator;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc100.Team100Robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;


// It moves up despacito
public class Deepspaceito extends Command {
  boolean done = false;
  double starttime = -1;
  public Deepspaceito() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.elevator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.elevator.elevatorMaster.set(ControlMode.PercentOutput, 0.3);
    //Robot.elevator.elevatorFollower.set(ControlMode.PercentOutput, 0.3);
    done = false;
    starttime = Timer.getFPGATimestamp();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Timer.getFPGATimestamp() - starttime >= 2){
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
    Robot.elevator.elevatorMaster.set(ControlMode.PercentOutput, 0);
    // /Robot.elevator.elevatorFollower.set(ControlMode.PercentOutput,0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
