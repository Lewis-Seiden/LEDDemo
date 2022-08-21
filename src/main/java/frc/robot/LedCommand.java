// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;


public class LedCommand extends CommandBase {
  private LedSubsystem led;
  private int hue;
  private int count;
  private int cycles;
  /** Creates a new LedCommand. */
  public LedCommand(LedSubsystem led) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.led = led;
    hue = 0;
    count = 0;
    cycles=0;

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    led.setSolidLEDColor(hue, 255, 255);
    count++;
    if (count == 2) {
      hue++;
      count = 0;
    }
    if(hue==180){
      hue=0;
      cycles++;
    }
  }

  // Called once the command ends or is interrupted.
  

  @Override
  public void end(boolean interrupted) {
    led.setSolidLEDColor(0,0,0);
  }
  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (cycles==5){
      return true;
    }
    return false;
  }
}
