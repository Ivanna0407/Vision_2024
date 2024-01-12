// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Manual_Movecmd;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Chasis_Sub;
import frc.robot.commands.Visioncmd;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  Chasis_Sub chasis= new Chasis_Sub();
  CommandXboxController chasis_control = new CommandXboxController(0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    //chasis.setDefaultCommand(new Manual_Movecmd(chasis,() -> chasis_control.getRightTriggerAxis(), () -> chasis_control.getLeftTriggerAxis(), () -> chasis_control.getRightX(), () -> chasis_control.b().getAsBoolean()));
    chasis.setDefaultCommand(new Visioncmd(chasis));
    configureBindings();
    
  }

 
  private void configureBindings() {
    //chasis_control.a().whileTrue(new Visioncmd(chasis));
  

  }
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
