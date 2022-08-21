// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LedSubsystem extends SubsystemBase {
  /** Creates a new Led. */
  AddressableLED led;
  AddressableLEDBuffer buffer;
  
  public LedSubsystem() {
    
    led = new AddressableLED(8);
    buffer = new AddressableLEDBuffer(70);
    led.setLength(buffer.getLength());
    led.start();
  }

  public void setSolidLEDColor(int h, int s, int v)
  {
    for (int i = 0; i < buffer.getLength(); i++){
      buffer.setHSV(i, h, s, v);
    }
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
