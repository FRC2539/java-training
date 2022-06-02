package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
    private WPI_TalonFX motor = new WPI_TalonFX(8, "CANivore");

    @Override
    public void robotInit() {}

    @Override
    public void robotPeriodic() {}

    @Override
    public void autonomousInit() {}

    @Override
    public void autonomousPeriodic() {}

    @Override
    public void teleopInit() {
        motor.set(0.3);
    }

    @Override
    public void teleopPeriodic() {}

    @Override
    public void disabledInit() {
        motor.stopMotor();
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
