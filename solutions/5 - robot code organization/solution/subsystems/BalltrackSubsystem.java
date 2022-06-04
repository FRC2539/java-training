package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BalltrackSubsystem extends SubsystemBase {
    private final WPI_TalonSRX conveyorMotor = new WPI_TalonSRX(Constants.BALLTRACK_CONVEYOR_MOTOR_PORT);
    private final WPI_TalonSRX chamberMotor = new WPI_TalonSRX(Constants.BALLTRACK_CHAMBER_MOTOR_PORT);

    private final AnalogInput conveyorProximitySensor = new AnalogInput(Constants.BALLTRACK_CONVEYOR_SENSOR_PORT);
    private final AnalogInput chamberProximitySensor = new AnalogInput(Constants.BALLTRACK_CHAMBER_SENSOR_PORT);

    private final double MOTOR_PERCENT_OUTPUT = 1;

    private final double PROXIMITY_SENSOR_THRESHOLD = 50;

    public BalltrackSubsystem() {
        conveyorMotor.setInverted(true);
        chamberMotor.setInverted(true);
    }

    public boolean isBalltackFull() {
        return isBallPresentInConveyor() && isBallPresentInChamber();
    }

    public boolean isBallPresentInConveyor() {
		return conveyorProximitySensor.getValue() < PROXIMITY_SENSOR_THRESHOLD;
	}

	public boolean isBallPresentInChamber() {
		return chamberProximitySensor.getValue() < PROXIMITY_SENSOR_THRESHOLD;
	}

    public void runBallTrack() {
        conveyorMotor.set(MOTOR_PERCENT_OUTPUT);
        chamberMotor.set(MOTOR_PERCENT_OUTPUT);
    }

    public void runConveyorOnly() {
        chamberMotor.stopMotor();
        conveyorMotor.set(MOTOR_PERCENT_OUTPUT);
    }

    public void stopBallTrack() {
        conveyorMotor.stopMotor();
        chamberMotor.stopMotor();
    }
}
