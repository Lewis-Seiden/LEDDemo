// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LED extends SubsystemBase {

  private AddressableLED m_led;
  private AddressableLEDBuffer m_ledBuffer;

  /** Creates a new LED. */
  public LED() {
    m_led = new AddressableLED(8);

    m_ledBuffer = new AddressableLEDBuffer(70);
    m_led.setLength(m_ledBuffer.getLength());


    m_led.start();
  }

  public void setColor(int hue) {
    for (int i = 0; i < m_ledBuffer.getLength(); i++) {
      m_ledBuffer.setHSV(i, hue, 243, 34);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
