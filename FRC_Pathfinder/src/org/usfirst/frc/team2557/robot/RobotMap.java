/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2557.robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static WPI_TalonSRX frontLeft, backLeft, frontRight, backRight, inLeft, inRight;
	
	public static SpeedControllerGroup leftSpeed, rightSpeed;
	
	public static DifferentialDrive diffDrive;
	
	public static void init() {
		frontLeft = new WPI_TalonSRX(1);
		frontRight = new WPI_TalonSRX(3);
		backLeft = new WPI_TalonSRX(7);
		backRight = new WPI_TalonSRX(2);
		inLeft = new WPI_TalonSRX(4);
		inRight = new WPI_TalonSRX(6);
		leftSpeed = new SpeedControllerGroup(frontLeft, backLeft);
		rightSpeed = new SpeedControllerGroup(frontRight, backRight);
		diffDrive = new DifferentialDrive(leftSpeed, rightSpeed);
	}
}