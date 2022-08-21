// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDSubsystem extends SubsystemBase {

  private AddressableLED m_led;
  private AddressableLEDBuffer m_ledBuffer;

  /** Creates a new LED. */
  public LEDSubsystem() {
    m_led = new AddressableLED(8);

    m_ledBuffer = new AddressableLEDBuffer(70);
    m_led.setLength(m_ledBuffer.getLength());


    m_led.start();
  }

  public void setColor(int hue) {
    for (int i = 0; i < m_ledBuffer.getLength(); i++) {
      m_ledBuffer.setHSV(i, (hue % 180), 243, 34);
    }
  }

  public void setLED(int hue, int whichLed) {
    m_ledBuffer.setHSV((whichLed % m_ledBuffer.getLength()), (hue % 180), 243, 34);
  }

  public int getBufferSize() {
    return m_ledBuffer.getLength();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
