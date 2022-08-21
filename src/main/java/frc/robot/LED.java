// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LED extends SubsystemBase {
  /** Creates a new LED. */
  AddressableLED led;
  AddressableLEDBuffer buffer;
  public LED() {
    led = new AddressableLED(8);
    buffer = new AddressableLEDBuffer(70);
    led.setLength(buffer.getLength());
    led.start();
  }
  

  public void setHue (int hue){
    for (int i = 0; i < 70; i++){
      buffer.setHSV(i, hue, 255, 255);
    }

  }
  public AddressableLEDBuffer returnBuffer (AddressableLEDBuffer buffer1){
    return buffer1;
   
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    led.setData(buffer);
  
  }
  

}
