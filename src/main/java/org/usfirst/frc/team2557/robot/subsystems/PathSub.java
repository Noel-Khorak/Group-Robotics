package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.PathComm;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PathSub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void Drive(double speed, double rotation) {
		RobotMap.diffDrive.arcadeDrive(speed, rotation);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new PathComm());
    }
}