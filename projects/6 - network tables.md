# Network Tables

Network Tables is a system that arises from the need for the driver station and the robot to communicate with each other.

Normally, Network Tables is used to send diagnostic data, create visualizations, and to select autonomous commands.

In this project, you will send useful data from the balltrack subsystem to Network Tables, which will be received by the driver station.

### Specific Requirements

-   Send the status of each proximity sensor (whether or not there is a ball there)
-   Send the current status of the balltrack (DISABLED, ENABLED, or any other custom mode you may have created)

**Note: send values to network tables within subsystem periodic functions unless they are not updated frequently.**

### Documentation

I would recommend reading the [network tables page](https://docs.wpilib.org/en/stable/docs/software/networktables/networktables-intro.html) on the WPILIB docs for a guide on basic network tables usage.

### Testing

I would recommend trying this out on the robot, so talk to the lead programmer or programming mentor about testing it.

If the robot is not currently available, the Robot Simulator (run from the _W_ button in VSCode) is able to display and modify network tables values, so you can verify your system there.

**You may need to enable the robot in teleop mode to see the values from network tables (this could be necessary in the simulator).**

### Optional Project

Given the simplicity of using Network Tables, this is a relatively easy optional project, but it is still a valuable skill to have.

Your task is to create a "testing" command for the balltrack subsytem. This command is similar to the command you already created, but for this one, the motor speeds must come from network tables.

This is useful when testing the mechanism, because it allows you to experiment with the motor speeds to find the combination with the best performance.

Don't forget to bind it to a button!

#### Hint

You may want to begin by creating a `TESTING` mode in the balltrack subsystem that handles using the speeds from the network tables.
