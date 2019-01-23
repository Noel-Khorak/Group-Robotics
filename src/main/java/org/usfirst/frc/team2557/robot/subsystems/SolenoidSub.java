//package org.usfirst.frc.team2557.robot.subsystems;
//
//import org.usfirst.frc.team2557.robot.Robot;
//import org.usfirst.frc.team2557.robot.RobotMap;
//
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
//import edu.wpi.first.wpilibj.command.Subsystem;
//
///**
// *
// */
//public class SolenoidSub extends Subsystem {
//
//    // Put methods for controlling this subsystem
//    // here. Call these from Commands.
//	public void sol() {
//		if (Robot.m_oi.solenoidButton.get() == true) {
//			RobotMap.sol1.set(Value.kForward);
//		} else if (Robot.m_oi.solButton.get() == true) {
//			RobotMap.sol1.set(Value.kReverse);
//		} else {
//			RobotMap.sol1.set(Value.kOff);
//		}
//	}
//    public void initDefaultCommand() {
//        // Set the default command for a subsystem here.
//        //setDefaultCommand(new MySpecialCommand());
//    }
//}