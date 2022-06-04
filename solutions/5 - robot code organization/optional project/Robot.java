package frc.robot;

import edu.wpi.first.wpilibj.TimesliceRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimesliceRobot {
    private RobotContainer robotContainer = new RobotContainer();

    public Robot() {
        super(Constants.ROBOT_PERIODIC_ALLOCATION, Constants.CONTROLLER_PERIOD);
    }
    
    @Override
    public void robotInit() {
        schedule(() -> robotContainer.getBalltrackSubsystem().update(), Constants.BALLTRACK_PERIOD);
    }

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
        CommandScheduler.getInstance().run();
	}

    @Override
    public void disabledInit() {}

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
