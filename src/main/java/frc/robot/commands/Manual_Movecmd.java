// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Chasis_Sub;

public class Manual_Movecmd extends Command {
  /** Creates a new Manual_Movecmd. */
    private final Chasis_Sub chasis;
      private final Supplier<Double> RT, LT, XAxis;
  private final Supplier<Boolean> B_Button;
  public Manual_Movecmd(Chasis_Sub Chasis, Supplier<Double> RT, Supplier<Double> LT, Supplier<Double> XAxis, Supplier<Boolean> B_Button) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.chasis=Chasis;
    this.RT=RT;
    this.LT=LT;
    this.XAxis=XAxis;
    this.B_Button=B_Button;
    addRequirements(chasis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double RightSpeed,LeftSpeed,Trigger,Turn,Boost;
     //Limpieza de ruido
     Trigger = RT.get() - LT.get(); if(Math.abs(Trigger)<0.15){Trigger = 0;}
     Turn = XAxis.get(); if(Math.abs(Turn)<0.25){Turn = 0;}
 
     //Filtro de velocidad
     if(B_Button.get()){Boost = 0.5;}else{Boost = 1;}
     
     //Calculo de velocidad
     RightSpeed = (Trigger + Turn)*Boost;
     LeftSpeed = (Trigger - Turn)*Boost;
 
     //Set a los motores
     chasis.setspeed(RightSpeed, LeftSpeed);
 

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
