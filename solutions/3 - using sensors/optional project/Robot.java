package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
    private WPI_TalonSRX conveyorMotor = new WPI_TalonSRX(11);
    private WPI_TalonSRX chamberMotor = new WPI_TalonSRX(12);

    private AnalogInput conveyorProximitySensor = new AnalogInput(0);
    private AnalogInput chamberProximitySensor = new AnalogInput(1);

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
		if (isBallPresentInConveyor() && isBallPresentInChamber()) {
			conveyorMotor.stopMotor();
            chamberMotor.stopMotor();
        } else if (isBallPresentInChamber()) {
            chamberMotor.stopMotor();
            conveyorMotor.set(-0.5);
        } else {
            conveyorMotor.set(-0.5);
            chamberMotor.set(-0.5);
        }
	}

	public boolean isBallPresentInConveyor() {
		return conveyorProximitySensor.getValue() < 50;
	}

	public boolean isBallPresentInChamber() {
		return chamberProximitySensor.getValue() < 50;
	}

    @Override
    public void disabledInit() {
        conveyorMotor.stopMotor();
        chamberMotor.stopMotor();
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
