/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2557.robot.commands.AutoComm;
import org.usfirst.frc.team2557.robot.subsystems.PathSub;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static OI m_oi;
	public static PathSub psub;
	// need to finish for the lift
	Command m_autonomousCommand;
	Command AutoCommmandGroup;
	Command PathComm;
	Command IntakeComm;
	
	
	SendableChooser<Command> m_chooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
		// initiate the lift
		psub = new PathSub();
		m_oi = new OI();
//		OI.init();
		m_oi.init();
//		m_chooser.addDefault("Default Auto", new AutoCommandGroup());
		// chooser.addObject("My Auto", new MyAutoCommand());
		//SmartDashboard.putData("Auto mode", m_chooser);
		
		m_chooser = new SendableChooser<>();
		m_chooser.addDefault("Auto Command", new AutoComm());
		SmartDashboard.putData("AUto mode", m_chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();
		

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		
		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Front Left auto", RobotMap.frontLeft.getSensorCollection().getQuadraturePosition());
		SmartDashboard.putNumber("Back Left fjdkla", RobotMap.backLeft.getSensorCollection().getQuadraturePosition());
		SmartDashboard.putNumber("Frofdasnt Right", RobotMap.frontRight.getSensorCollection().getQuadraturePosition());
		SmartDashboard.putNumber("Back fdfdfd Right", RobotMap.backRight.getSensorCollection().getQuadraturePosition());
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		
		
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Front Left", RobotMap.frontLeft.getSensorCollection().getQuadraturePosition());
		SmartDashboard.putNumber("Back Left", RobotMap.backLeft.getSensorCollection().getQuadraturePosition());
		SmartDashboard.putNumber("Front Right", RobotMap.frontRight.getSensorCollection().getQuadraturePosition());
		SmartDashboard.putNumber("Back Right", RobotMap.backRight.getSensorCollection().getQuadraturePosition());
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
