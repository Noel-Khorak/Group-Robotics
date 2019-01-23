/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2557.robot;
import java.io.File;
import java.io.IOException;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static WPI_TalonSRX frontLeft, backLeft, frontRight, backRight, inLeft, inRight, lift1, lift2;
	public static SpeedControllerGroup leftSpeed, rightSpeed;
	public static DifferentialDrive diffDrive;
	public static DoubleSolenoid sol1;
	public static MecanumDrive mecDrive;
	public static Trajectory t1;
	
	public static void init() {
		frontLeft = new WPI_TalonSRX(1);
		frontRight = new WPI_TalonSRX(3);
		backLeft = new WPI_TalonSRX(7);
		backRight = new WPI_TalonSRX(2);
		inLeft = new WPI_TalonSRX(4);
		inRight = new WPI_TalonSRX(6);
		lift1 = new WPI_TalonSRX(5);
		lift2 = new WPI_TalonSRX(11);
		frontLeft.setSafetyEnabled(false);
		frontRight.setSafetyEnabled(false);
		backLeft.setSafetyEnabled(false);
		backRight.setSafetyEnabled(false);
		Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.02, 8.5, 10.0, 1000000.0);
				Trajectory.Config configFaster = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.02, 10.0, 10.0, 1000000.0);
//		sol1 = new DoubleSolenoid(0, 0, 1);
		leftSpeed = new SpeedControllerGroup(frontLeft, backLeft);
		rightSpeed = new SpeedControllerGroup(frontRight, backRight);
		diffDrive = new DifferentialDrive(leftSpeed, rightSpeed);
//		mecDrive = new MecanumDrive(frontLeft, backLeft, backRight, frontRight);
		Waypoint[] waypoint1 = new Waypoint[] {
			new Waypoint(-3, 0, -Math.PI),
			new Waypoint(0, 0, 0)
		};
		t1 = Pathfinder.generate(waypoint1, config);
		File t1file = new File("/home/lvuser/Trajectories/t1file.t");
		try {
			t1file.createNewFile();
			Pathfinder.writeToFile(t1file, t1);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
		
		t1 = Pathfinder.readFromFile(new File("/home/lvuser/Trajectories/t1file.t"));
	}
}