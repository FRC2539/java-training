package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BalltrackSubsystem;

public class TestBalltrackCommand extends CommandBase {
    private BalltrackSubsystem balltrackSubsystem;

    public TestBalltrackCommand(BalltrackSubsystem balltrackSubsystem) {
        this.balltrackSubsystem = balltrackSubsystem;
    }

    @Override
    public void execute() {
        balltrackSubsystem.testBalltrack();
    }

    @Override
    public void end(boolean interrupted) {
        balltrackSubsystem.disableBalltrack();
    }
}
