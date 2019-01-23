/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;

public class PathfinderDrive extends Command {
  Timer t;
  Trajectory trajectory;
  EncoderFollower encoderMan;
  public PathfinderDrive(Trajectory trajectory) {
    t = new Timer();
    requires(Robot.psub);
    this.trajectory = trajectory;
    encoderMan = new EncoderFollower(trajectory);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    t.reset();
    t.start();
    encoderMan.reset();
    RobotMap.backLeft.getSensorCollection().setQuadraturePosition(0, 10);
    RobotMap.backRight.getSensorCollection().setQuadraturePosition(0, 10);
    encoderMan.configurePIDVA(0.07, 0, 0.001, 1.0/10, 0.001);
    encoderMan.configureEncoder(0, 3413, 1.0/3.0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double power = encoderMan.calculate(RobotMap.backRight.getSensorCollection().getQuadraturePosition());
    Robot.psub.Drive(-power, 0);
    t.reset();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(encoderMan.isFinished()){
      return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.psub.Drive(0, 0);
    RobotMap.backLeft.getSensorCollection().setQuadraturePosition(0, 10);
    RobotMap.backRight.getSensorCollection().setQuadraturePosition(0, 10);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    RobotMap.frontRight.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
    	RobotMap.backRight.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
    	RobotMap.frontLeft.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
    	RobotMap.backLeft.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
    	this.end();
  }
}
