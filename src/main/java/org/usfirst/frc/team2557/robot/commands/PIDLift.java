// package org.usfirst.frc.team2557.robot.commands;

// import org.usfirst.frc.team2557.robot.RobotMap;

// import edu.wpi.first.wpilibj.command.Command;

// /**
//  *
//  */
// public class PIDLift extends Command {
// 	double error, speed, P;
//     public PIDLift() {
//         // Use requires() here to declare subsystem dependencies
//         // eg. requires(chassis);
//     }

//     // Called just before this Command runs the first time
//     protected void initialize() {
//     	error = 50;
//     	speed = 0.7;
//     	P = 0.05;
//     }

//     // Called repeatedly when this Command is scheduled to run
//     protected void execute() {
//     	error = error - speed;
//     	speed = error*P;
//     	RobotMap.lift1.set(speed);
//     	RobotMap.lift2.set(speed);
//     }

//     // Make this return true when this Command no longer needs to run execute()
//     protected boolean isFinished() {
//     	if (RobotMap.lift1.getSensorCollection().getQuadraturePosition() >= error) {
    		
//     	}
//         return false;
//     }

//     // Called once after isFinished returns true
//     protected void end() {
//     }

//     // Called when another command which requires one or more of the same
//     // subsystems is scheduled to run
//     protected void interrupted() {
//     }
// }
