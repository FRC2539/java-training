package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class Robot extends TimedRobot {
    private WPI_TalonSRX conveyorMotor = new WPI_TalonSRX(11);
    private WPI_TalonSRX chamberMotor = new WPI_TalonSRX(12);

    private AnalogInput conveyorProximitySensor = new AnalogInput(0);
    private AnalogInput chamberProximitySensor = new AnalogInput(1);

    private Joystick joystick = new Joystick(0);

    // Button 3 corresponds to the left thumb button 
    // on our thrustmaster joystick
    private JoystickButton button = new JoystickButton(joystick, 3);

    @Override
    public void robotInit() {}

    @Override
    public void robotPeriodic() {}

    @Override
    public void autonomousInit() {}

    @Override
    public void autonomousPeriodic() {}

    @Override
    public void teleopInit() {}

    @Override
    public void teleopPeriodic() {
        if (button.get())
            runBallTrack();
        else
            stopBallTrack();
	}

    public void runBallTrack() {
        if (isBallPresentInConveyor() && isBallPresentInChamber()) {
			stopBallTrack();
        } else if (isBallPresentInChamber()) {
            chamberMotor.stopMotor();
            conveyorMotor.set(-0.5);
        } else {
            conveyorMotor.set(-0.5);
            chamberMotor.set(-0.5);
        }
    }

    public void stopBallTrack() {
        conveyorMotor.stopMotor();
        chamberMotor.stopMotor();
    }

	public boolean isBallPresentInConveyor() {
		return conveyorProximitySensor.getValue() < 50;
	}

	public boolean isBallPresentInChamber() {
		return chamberProximitySensor.getValue() < 50;
	}

    @Override
    public void disabledInit() {
        stopBallTrack();
    }

    @Override
    public void disabledPeriodic() {}

    @Override
    public void testInit() {}

    @Override
    public void testPeriodic() {}

    @Override
    public void simulationInit() {}

    @Override
    public void simulationPeriodic() {}
}
