package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BalltrackSubsystem;

public class RunBalltrackCommand extends CommandBase {
    private BalltrackSubsystem balltrackSubsystem;

    public RunBalltrackCommand(BalltrackSubsystem balltrackSubsystem) {
        this.balltrackSubsystem = balltrackSubsystem;
    }

    @Override
    public void execute() {
        if (balltrackSubsystem.isBalltackFull())
            balltrackSubsystem.stopBallTrack();
        else if (balltrackSubsystem.isBallPresentInChamber())
            balltrackSubsystem.runConveyorOnly();
        else
            balltrackSubsystem.runBallTrack();
    }

    @Override
    public void end(boolean interrupted) {
        balltrackSubsystem.stopBallTrack();
    }
}
