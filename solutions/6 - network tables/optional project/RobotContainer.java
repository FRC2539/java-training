package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.RunBalltrackCommand;
import frc.robot.commands.TestBalltrackCommand;
import frc.robot.subsystems.BalltrackSubsystem;

public class RobotContainer {
    private final Joystick joystick = new Joystick(0);

    private final JoystickButton leftThumbButton = new JoystickButton(joystick, 3);
    private final JoystickButton rightThumbButton = new JoystickButton(joystick, 4);

    private final BalltrackSubsystem balltrackSubsystem = new BalltrackSubsystem();

    public RobotContainer() {
        CommandScheduler.getInstance().registerSubsystem(balltrackSubsystem);

        configureControllerLayout();
    }

    private void configureControllerLayout() {
        leftThumbButton.whileHeld(new RunBalltrackCommand(balltrackSubsystem));
        rightThumbButton.whileHeld(new TestBalltrackCommand(balltrackSubsystem));
    }

    public BalltrackSubsystem getBalltrackSubsystem() {
        return balltrackSubsystem;
    }
}
