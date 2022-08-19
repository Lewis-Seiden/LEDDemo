// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.TimedRobot;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  //Creates an led object, and a buffer that we store what colors we want in.
  AddressableLED led;
  AddressableLEDBuffer buffer;
  private int counter;
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
  
    //sets up the leds
    led = new AddressableLED(8); // 8 is the port the leds are on
    // 70 leds / 2 leds per index
    buffer = new AddressableLEDBuffer(70);
    led.setLength(buffer.getLength());
    led.start();
    counter = 0;
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    setBlinkingColor(67, 13, 154);
    setRainbowColor(0, 100, 50);
    led.setData(buffer);
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    setSolidLEDColor(150, 255, 255);
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {
    setSolidLEDColor(0, 0, 0);
  }

  private void setSolidLEDColor(int h, int s, int v){
    for (int i = 0; i < buffer.getLength(); i ++){
      buffer.setHSV(i, h, s, v);
    }
  }
  private void setBlinkingColor(int h, int s, int v){
    counter++;
    if (counter % 2 == 1) {
      setSolidLEDColor(h, s, v);
    } else {
      setSolidLEDColor(0, 0, 0);
    }


  }

  private void setRainbowColor(int h, int s, int v) {
    counter++;
    if (counter % 7 == 1) {
      setSolidLEDColor(h, s, v); //red
    } else if (counter % 7 == 2){
      setSolidLEDColor(h+25, s, v); //orange
    } else if (counter % 7 == 3){
      setSolidLEDColor(h+50, s, v); //yellow
    } else if (counter % 7 == 4){
      setSolidLEDColor(h+100, s, v); //green
    } else if (counter % 7 == 5){
      setSolidLEDColor(h+200, s, v); //blue
    } else if (counter % 7 == 6){
      setSolidLEDColor(h+275, s, v); //purple
    } else {
      setSolidLEDColor(h+315, s, v); //pink
    }
  }
}
