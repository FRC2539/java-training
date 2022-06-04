package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.RunBalltrackCommand;
import frc.robot.subsystems.BalltrackSubsystem;

public class RobotContainer {
    private final Joystick joystick = new Joystick(0);

    // Button 3 corresponds to the left thumb button 
    // on our thrustmaster joystick
    private final JoystickButton button = new JoystickButton(joystick, 3);

    private final BalltrackSubsystem balltrackSubsystem = new BalltrackSubsystem();

    public RobotContainer() {
        CommandScheduler.getInstance().registerSubsystem(balltrackSubsystem);

        configureControllerLayout();
    }

    private void configureControllerLayout() {
        button.whileHeld(new RunBalltrackCommand(balltrackSubsystem));
    }

    public BalltrackSubsystem getBalltrackSubsystem() {
        return balltrackSubsystem;
    }
}
