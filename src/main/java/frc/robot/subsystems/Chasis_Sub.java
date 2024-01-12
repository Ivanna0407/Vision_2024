// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.*;

public class Chasis_Sub extends SubsystemBase {
  //Build de motores, es necesario escribir a mano los id y el tipo de motor y revisar que el método sea el correcto 
  private final CANSparkMax Right_Motor_M = new CANSparkMax(7,MotorType.kBrushless);
  private final CANSparkMax Right_Motor_S= new CANSparkMax(3,MotorType.kBrushless);
  private final CANSparkMax Left_Motor_M = new CANSparkMax(9,MotorType.kBrushless);
  private final CANSparkMax Left_Motor_S= new CANSparkMax(5,MotorType.kBrushless);
  public Chasis_Sub() {
  //Setear de fabrica 
  Right_Motor_M.restoreFactoryDefaults();
  Right_Motor_S.restoreFactoryDefaults();
  Left_Motor_M.restoreFactoryDefaults();
  Left_Motor_S.restoreFactoryDefaults();
  //Declarar esclavos y maestros 
  Right_Motor_S.follow(Right_Motor_M);
  Left_Motor_S.follow(Left_Motor_M);
  //IDLE mode 
  Right_Motor_M.setIdleMode(IdleMode.kBrake);
  Right_Motor_S.setIdleMode(IdleMode.kBrake);
  Left_Motor_M.setIdleMode(IdleMode.kBrake);
  Left_Motor_S.setIdleMode(IdleMode.kBrake);
  // Set inverted por el tipo tanque 
  Left_Motor_M.setInverted(true);
  Left_Motor_S.setInverted(true);
  //Set a 0 por seguridad 
  Left_Motor_S.set(0);
  Left_Motor_M.set(0);
  Right_Motor_M.set(0);
  Right_Motor_S.set(0);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Velocidad_R", Right_Motor_M.get());
    SmartDashboard.putNumber("Velocidad_L", Left_Motor_M.get());
  }

  public void setspeed(double rightSpeed,double leftSpeed){
    if (Math.abs(leftSpeed) >= 0.8) {
      leftSpeed = (leftSpeed / Math.abs(leftSpeed)) * 0.8;
    }
    if (Math.abs(rightSpeed) >= 0.8) {
      rightSpeed = (rightSpeed / Math.abs(rightSpeed)) * 0.8;
    }
    Left_Motor_M.set(leftSpeed*.8);
    Right_Motor_M.set(rightSpeed*.8);
  }

  public void SetopenLoopS(double S){
    Right_Motor_M.setOpenLoopRampRate(S);
    Right_Motor_S.setOpenLoopRampRate(S);
    Left_Motor_M.setOpenLoopRampRate(S);
    Left_Motor_S.setOpenLoopRampRate(S);
  }
  public double getTx(){
    return NetworkTableInstance.getDefault().getTable("limelight-abtomat").getEntry("tx").getDouble(0);
  }

  public double getTy(){
    return NetworkTableInstance.getDefault().getTable("limelight-abtomat").getEntry("ta").getDouble(0);
  }

  public double getTa(){
    return NetworkTableInstance.getDefault().getTable("limelight-abtomat").getEntry("ta").getDouble(10);
  }

  }
  