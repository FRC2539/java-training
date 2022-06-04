# Robot Code Organization

In this large and complex project, will be doing something very important.

Up until this point, we have stored all of our code in `Robot.java`. This is great for simple code, but as our systems get more complex, we will only end up with a long, unstructured, and difficult to understand `Robot.java` file.

Therefore, we will use a robot code framework to organize our code. We will be choosing the "command based framework" available in WPILIB.

Your task is to refactor our current code into a well-organized command based robot.

### Specific Requirements

-   Create a subsystem that manages and provides an interface to the robot balltrack.
-   Create a command that runs the balltrack and stops it once the command ends.
-   Use a `RobotContainer` file to store, setup, and bind your subsystem and command (the command is bound to the button from the last project).

### Useful webpages

Given the complexity of this project, I am linking various important pages here for your assistance. I would strongly recommend reading these to understand how the framework works and how to successfully implement it.

-   [What Is “Command-Based” Programming?](https://docs.wpilib.org/en/stable/docs/software/commandbased/what-is-command-based.html) - Provides an overview of command-based programming
-   [Subsystems](https://docs.wpilib.org/en/stable/docs/software/commandbased/subsystems.html) - Explains how to create subsystems
-   [Commands](https://docs.wpilib.org/en/stable/docs/software/commandbased/commands.html) - Explains how to create commands
-   [The Command Scheduler](https://docs.wpilib.org/en/stable/docs/software/commandbased/command-scheduler.html) - Recommended reading; explains how command based code is run behind the schenes
-   [Binding Commands to Triggers](https://docs.wpilib.org/en/stable/docs/software/commandbased/binding-commands-to-triggers.html) - Recommended reading; explains how to use buttons in a command based way, rather than an imperative way
-   [Structuring a Command-Based Robot Project](https://docs.wpilib.org/en/stable/docs/software/commandbased/structuring-command-based-project.html) - Explains how to structure robot code, as well as some information on the `RobotContainer`.
-   [ArmBot Example](https://github.com/wpilibsuite/allwpilib/tree/main/wpilibjExamples/src/main/java/edu/wpi/first/wpilibj/examples/armbot) - Provides a simple example of `Robot.java`, `RobotContainer.java`, and `Constants.java`.
-   [2539 PracticeBot](https://github.com/FRC2539/practicebot/tree/08f0ba23bc9e5515ac6f05e7efee8af668376946/src/main/java/frc/robot) - Demonstrates an actual implementation of a robot by our team. I would highly recommend looking at this.

### Other important information

-   Your subsystems should be stored in a `subsystems` folder, and your commands in a `commands` folder.
-   Many examples from WPILIB name everything starting with `m_...`. We don't do that in our code. For more style tips, look at the practice bot code.

With that, good luck, and enjoy your refactoring!

### Optional Project

The robot type we have used thus far is called `TimedRobot`. It automatically manages the command loops and the subsystem periodic functions, and runs them at 50 Hz (every 20 ms). If you want to learn more about how these loops are run, check the _Command Scheduler_ article above.

On our actual robot, the 20 ms loop is simply too slow and unstructured for many important functions we perform with the robot, so we use something called `TimesliceRobot`.

This allows us to define "timeslices" for robot loops and periodics, as well as for custom functions. We are then able to run these at much faster rates, such as every 5 ms (200 Hz). Additionally, these timeslices are run at consistent times, which is advantageous for complex systems like PID controllers and odometry (feel free to read more on the docs).

We supply two main numbers to the `TimesliceRobot`: the robot periodic allocation and the controller period. The controller period is essentially how much time is allocated for the entire robot code to run once. Given our example above, this would be 5 ms (0.005). The robot periodic allocation is how much time we allocate for `TimedRobot` operations, like subsystem periodic functions and command execute loops. By default we use 2 ms (0.002) for this, although these loops still only run every 20 ms, so the OS uses this free time to perform other operations behind the scenes.

Continuing our example, with this setup, we now only have 3 ms remaining for any custom loops we would like to schedule (see the docs for how to schedule these loops, and the practicebot code for a well-defined way of doing this repeatedly). As an example, the practice bot allocates 1.5 ms for the `update` function in the `SwerveDriveSubsystem`, leaving only 1.5 ms for any other subsystems.

Overall, this is more of a learning project than a strongly structured task. Simply: use the `TimesliceRobot` to run your robot code. You could, for example, utilize the faster loop rate to schedule a function that automatically manages the balltrack in the subsystem (updating every 5 ms), while using a command to tell it to start/stop.

Good luck! This can be a difficult concept, so you can always skip this and come back later.
