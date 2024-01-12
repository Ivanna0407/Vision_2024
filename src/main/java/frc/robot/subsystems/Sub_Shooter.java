// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Sub_Shooter extends SubsystemBase {
  private final CANSparkMax Motorshoot= new CANSparkMax(10, MotorType.kBrushless);


  public Sub_Shooter() {
    Motorshoot.restoreFactoryDefaults();
    Motorshoot.setIdleMode(IdleMode.kBrake);
    Motorshoot.set(0);
    Motorshoot.setOpenLoopRampRate(0.75);
    Motorshoot.setInverted(true);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Velocidad: ", Motorshoot.get());
  }
  public void setSpeed(double S){
    Motorshoot.set(S);
  }
}
