# Subsystems (personal project)

_There are no solutions for this module, as they already exist in the current robot code._

In this final project, you will be free to choose what you create!

You can create any one or combination of subsytems and their respective commands from this year's game (2022).

As always, take full advantage of the documentation available online.

**All information needed for the 2022 robot can be found on the [Javabot Github page](https://github.com/FRC2539/javabot). See the `constants` file for the ports you need, and `common/controller` for the controller code.**

Choose one or more of the the subsystems and build it! This is a challenging project, so ask questions when necessary.

##### Useful Java Features

I recommend looking up a few Java features to make it easier to create complex logic.

-   Switch Statements
-   Enums
-   Optionals
-   Abstract classes
-   Suppliers (`DoubleSupplier` in particular)
-   Using `this` to make multiple constructors more easily

##### NetworkTablesSubsystem

In Javabot I have all of the subsystems extend an abstract class called "NetworkTablesSubsystem". This subsystem, linked [here](https://github.com/FRC2539/javabot/blob/development/src/main/java/frc/robot/subsystems/NetworkTablesSubsystem.java), makes it easier to interact with Network Tables within subsystems that extend it.

Feel free to copy and use this abstract subsystem class within your project!

### Balltrack Subsystem

While this was the focus of the projects up until this point, there is much, much more to do for this subsystem.

Most of the work for this subsystem will go into internal logic rather than running complex mechanisms with precision (like the shooter or drivetrain).

#### Subsystem Guidelines

-   This subsystem should abstract away (hide) the complexity of controlling the intake, conveyor, and chamber.
    -   The intake was not a part of the previous projects, but see the constants file linked above for the motor port.
    -   Additionally, you will need to control the intake piston (`DoubleSolenoid`), so check the constants and the docs for guidance on doing so.
        -   FYI: We use REV Pneumatics Hub
-   The commands that use this subsystem should only call a few functions from the subsystem. The subsystem should handle the complex logic behind the scenes, while the commands just "give commands".
-   The subsystem should have modes for intaking and shooting at the minimum.
    -   Some other possibilities are intaking and shooting, reversing the system, and preparing the balls to shoot without using the intake.
-   Create a command for intaking balls, and any others if you choose to create complementary subsystems (like the shooter).

### Shooter Subsystem

The shooter subsystem is a relatively simple subsystem, yet it has some intruiging aspects.

It controls the shooting motors as well as the angle that the shooter shoots at.

Additionally, it is responsible for calculating the correct RPM values for a given distance from the target.

#### Important Information

**Make sure to configure your motors through the CANivore for this subsystem (see constants linked above for the CANivore name).**

The shooter uses two `WPI_TalonFX` motors (see constants file above) for the shooter and a `DoubleSolenoid` for setting the angle of the shooter.

The shooter motors are geared at a gear ratio of 3:2, and the front shooter motor should be inverted in order to shoot the balls correctly. Also, make sure that the shooter motors are run in coast mode (neutral mode).

To convert RPM (rotations/revolutions per minute) to Talon Units, follow the given expression:

`(rpm * 2048 * GEAR_RATIO) / 600`

Undo the math in order to calculate the current RPMs.

#### Subsystem Guidelines

**I recommend looking at `common/control/ShooterState.java` and `common/control/ShooterStateMap.java` in Javabot (linked at the top). Feel free to reuse these in your own project.**

-   The subsystem should encapsulate all shooting functionality, making it easily accessible in commands. Some of these features include:
    -   Calculating the correct shooter state for the given distance
    -   Custom shooting states for fender shoots (right against the hub)
    -   Simple functions for setting the state of the shooter and stopping it
        -   **Check out the [WPILIB PID tuning page](https://docs.wpilib.org/en/stable/docs/software/advanced-controls/introduction/tuning-pid-controller.html) for guidance on tuning the PID values for the shooter.**
        -   Additionally, you may want to ask an experienced programmer for help in doing this.
    -   Sending the current RPMs to the network tables
    -   Creating a test command that shoots at RPMs sent via network tables to the robot
    -   (If you created the limelight subsystem) Shooting using the distance value from the limelight
    -   (If you created the balltrack subsystem) Creating a comprehensive shooting command(s) that uses the balltrack to feed balls into the shooter

### Climber Subsystem

The climber subsystem moves the climber up and down, as well as changes the angle for traversal climbing.

#### Important Information

**Make sure to configure your motor through the CANivore for this subsystem (see constants linked above for the CANivore name).**

The climber uses one `WPI_TalonFX` motor (see constants file above) for raising and lowering the climber and a `DoubleSolenoid` for setting the angle of the climber (we use REVPH control for pneumatics).

The soft (encoder) limits of the shooter are very important, so they are given for this subsystem. Make sure to enable them when configuring the motor.

-   Upper Limit - 230000
-   Lower Limit - 8000

Additionally, the climber should be run at 100% output with a 0.5 second ramp duration. Since we want the climber to stop when it is told to, make sure the neutral mode is brake.

#### Subsystem Guidelines

-   The climber subsystem should enable simple control of raising, lowering, stopping, and angling the climber arm.
-   Create commands for all of the previously listed features.

### Vision and Lights Subsystems

Limelight, machine learning, and lights all have their own subsystems, but they are unlikely to vary much year-to-year. For that reason, and because they are simple and often just wrap lower level details or interfaces, I am not making these subsystems a choice for this project.

If you are interested in understanding them, I do recommend looking at them in Javabot (linked above).

Also, if you do copy or implement them yourself, they will make your subsystems project more interesting (e.g. shooting with the distance calculated by the limelight).

### Swerve Drive Subsystem

**Currently, I advise against starting with the Swerve Drive Subsystem, unless you have a strong desire to do so. It will take much longer than any other subsystem, and it isn't necessary to have this level of skill before programming the actual robot.**

To begin, the Swerve Drive Subsystem is definitely the hardest and most complex subsystem to implement.

It involves not only being able to correctly control a complex system like a swerve drivetrain, but a fully featured swerve drive can also follow PathPlanner/PathWeaver/WPILIB trajectories.

**Additionally, our swerve drive is run through a CANivore and two of the motors are inverted, so we use our own custom implementation of the SDS (Swerve Drive Specialties) Library rather than the one you can find online. You can find ours [here](https://github.com/FRC2539/javabot/tree/development/src/main/java/com/swervedrivespecialties/swervelib).**

Given the difficulty of writing the code yourself, you may be tempted to copy an example project. That is okay, but make sure that you either add your own contribution to the code you create. If you want to get the most out of this project, create as much as possible from scratch. Being able to write your own swerve drive code is a strong foundation for rapidly writing robot code.

#### Great Resources

-   The [Javabot swerve drive subsystem](https://github.com/FRC2539/javabot/blob/development/src/main/java/frc/robot/subsystems/SwerveDriveSubsystem.java) is our own implementation of swerve drive, so you can use this as a solution. If you read it too readily you may end up copying it.
-   ~~SDS has their own [swerve template](https://github.com/SwerveDriveSpecialties/swerve-template) with great example code. Along with the warnings for the previous resource, be wary of their gyroscope implementation as it is based on the Pigeon IMU rather than the NavX that we currently use.~~
-   See the ["Swerve Drive Kinematics"](https://docs.wpilib.org/en/stable/docs/software/kinematics-and-odometry/swerve-drive-kinematics.html) article on WPILIB docs for a guide on the built-in swerve code in WPILIB.

#### Important Information

-   Our `TRACKWIDTH` and `WHEELBASE` are both `0.5969` meters
-   The maximum voltage we will use is 12 V.
-   Our swerve modules are `MK4_L2`
-   We use the NavX through the default port (library [here](https://pdocs.kauailabs.com/navx-mxp/software/roborio-libraries/java/))
-   In our current swerve implementation, the front right and back right modules both have their drive motors inverted
-   See the constants file for the ports and module offsets
-   Feel free to reuse the `SwerveDriveSignal` class that can be found in `common/control` in Javabot

#### Subsystem Guidelines

-   Create the subsystem 👍
-   All commands that use this subsystem should only need to call simple functions to interact with the subsystem, not handle the complex logic (associated with the subsystem)
    -   It is fine if the commands have custom logic, but the interaction with the subsystem itself should be simple
-   Create a default command for the swerve drive subsystem that enables driving using the Joysticks or another controller
-   Configure a button to reset the gyro angle back to zero when it is pressed
-   **Optional:**
    -   (If you created the limelight subsystem) Create a command that allows normal driving but aims the robot (rotation) towards the target using the limelight
    -   (If you created the machine learning subsystem) Create a command that picks up balls off the field (automatic ball pickup)
    -   Add the ability to follow trajectories (we use PathPlanner, so you will need to use that library)
    -   Create an autonomous manager, that makes it simple to construct dynamic autonomous functions (feel free to reference the code in `utils` in Javabot).
        -   Make sure to send the proper data to the network tables so the driver can use the dashboard to select an auto. The correct entry names can be found [here](https://github.com/FRC2539/Cougar-Dashboard/blob/main/src/components/autos.jsx).
