package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.LiftComm;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftSub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void moveLift(double speed) {
		RobotMap.lift1.set(-speed);
		RobotMap.lift2.set(-speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new LiftComm());
    }
}

