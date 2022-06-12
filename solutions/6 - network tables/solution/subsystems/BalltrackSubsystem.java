package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
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

    private boolean ballPresentInConveyor = false;
    private boolean ballPresentInChamber = false;

    private BalltrackMode currentMode = BalltrackMode.DISABLED;

    private NetworkTableEntry conveyorSensorEntry;
    private NetworkTableEntry chamberSensorEntry;
    private NetworkTableEntry balltrackModeEntry;

    private NetworkTable balltrackTable;

    public BalltrackSubsystem() {
        conveyorMotor.setInverted(true);
        chamberMotor.setInverted(true);

        balltrackTable = NetworkTableInstance.getDefault().getTable("balltrack");

        conveyorSensorEntry = balltrackTable.getEntry("ballPresentInConveyor");
        chamberSensorEntry = balltrackTable.getEntry("ballPresentInChamber");
        balltrackModeEntry = balltrackTable.getEntry("balltrackMode");
    }

    public void enableBalltrack() {
        currentMode = BalltrackMode.ENABLED;
    }

    public void disableBalltrack() {
        currentMode = BalltrackMode.DISABLED;
    }

    public void update() {
        ballPresentInConveyor = isBallPresentInConveyor();
        ballPresentInChamber = isBallPresentInChamber();

        switch (currentMode) {
            case DISABLED:
                stopBallTrack();
                break;
            case ENABLED:
                if (isBalltackFull())
                    stopBallTrack();
                else if (ballPresentInChamber)
                    runConveyorOnly();
                else
                    runBallTrack();
                break;
        }
    }

    @Override
    public void periodic() {
        conveyorSensorEntry.setBoolean(ballPresentInConveyor);
        chamberSensorEntry.setBoolean(ballPresentInChamber);
        balltrackModeEntry.setString(currentMode.name());
    }

    public boolean isBalltackFull() {
        return ballPresentInConveyor && ballPresentInChamber;
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

    private enum BalltrackMode {
        DISABLED,
        ENABLED
    }
}
