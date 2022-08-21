// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import org.opencv.ml.Ml;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LEDSubsystem;

public class LEDRainbowCooler extends CommandBase {
  /** Creates a new LEDRainbowCooler. */
  LEDSubsystem m_LED;

  public LEDRainbowCooler(LEDSubsystem LED) {
    m_LED = LED;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(LED);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    for (int i = 0; i < m_LED.getBufferSize(); i++) {
      m_LED.setLED((2*i), i);
    }
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
