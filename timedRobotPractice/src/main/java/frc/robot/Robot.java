// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private DigitalInput beamIn;
  private DigitalInput beamIn2;
  private TalonSRX leftFront;
  private TalonSRX leftBack;
  private TalonSRX rightFront;
  private TalonSRX rightBack;
  
  

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {

    beamIn = new DigitalInput(1);
    SmartDashboard.putBoolean("Beam Breaker", beamIn.get());
    SmartDashboard.putBoolean("Beam Breaker 2", beamIn2.get());
    leftFront = new TalonSRX(2);
    leftBack = new TalonSRX(1);
    rightFront = new TalonSRX(4);
    rightBack = new TalonSRX(3);

    rightBack.follow(rightFront);
    leftBack.follow(leftFront);

    rightBack.setInverted(true);
    rightFront.setInverted(true);
    
    
    
  }
    
  @Override
  public void robotPeriodic() {
    System.out.println("meow");
  }



  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() { 

    if(!beamIn.get()) {
      rightFront.set(ControlMode.PercentOutput, 0.3);
    } else if(!beamIn2.get()) {
      leftFront.set(ControlMode.PercentOutput, 0.3);
    } else {
      rightFront.set(ControlMode.PercentOutput, 0);
      leftFront.set(ControlMode.PercentOutput, 0);
    }
      
    
  }

    

  public void autonomousInit() {
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {


  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}



  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}