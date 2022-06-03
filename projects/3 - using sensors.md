# Using Sensors

In this section, we will build on the previous section, in which we controlled a motor.

We will use an analog proximity sensor to detect a game piece, and if that is present, we will stop the motor automatically.

### Important Information

From here on out, the instructions will be more general, and you will be expected to utilize documentation and other resources you can find online to complete tasks, rather than just blindly copying code.

The following are useful resources for FRC Java programming:

-   [WPILIB Java Docs](https://first.wpi.edu/wpilib/allwpilib/docs/release/java/index.html) - This should be your go-to resource for the wpilib Java library.
-   [WPILIB Docs](https://docs.wpilib.org/en/stable/index.html) - Great explanations of many important aspects of FIRST Robotics. Additionally, it may be more informative than the simple Java docs.

### 1. Initializing the sensor

In `Robot`, create an `AnalogInput` for communication with the proximity sensor. It is on port `0`.

**Note: this port is for the 2022 robot; ask a trustworthy programmer for the updated number.**

### 2. Getting sensor data

Create a function within `Robot` that returns whether or not the proximity sensor sees a game piece.

#### Important details:

-   These sensors are manually configured.
-   When `sensor.getValue()` is less than `50`, a object is within the calibrated proximity.

### 3. Using sensor data

First, remove the code from `teleopInit`; we are moving our logic into `teleopPeriodic`, where it will be run every 20 ms (~ 50 Hz).

Add logic to only run the motor when the proximity sensor does not detect a game piece. If it detects a game piece, make sure the motor stops.

### 4. Testing your code

**Make sure that you are being supervised by a trustworthy programmer when you test your code.**

Now, connect to the robot wifi, click the W (WPILIB) icon at the top right of VSCode, and select "Deploy Robot Code".

If you need assistance with this, talk to a trustworthy member of the programming team.

Finally, test the code by enabling the robot, and if everything is correct, the motor should be spinning. Next, safely place a game piece in front of the proximity sensor. If it is correctly calibrated, the light should turn red, and the motor should stop.

If it is incorrectly calibrated, confirm with a trustworthy programmer (lead programmer or programming mentor), and then ask mechanical to help you calibrate it if you are unfamiliar with how to do so.

When you are satisfied, click disable (or press enter), which will disable the robot.

Nice job!

### 5. Optional Project!

To enhance your skills, this project will have you program the ball track on a 2022 (Rapid React) style robot.

Given the additional complexity, only necessary information will be provided, and it will be up to you to correctly implement the logic.

#### Explanation of the ball track

Balls enter through the intake, and from there, the conveyor moves the balls through the robot and towards the chamber. The chamber holds one ball ready to shoot, while the conveyor can then hold a second ball.

#### Important information

**Ports**
Conveyor Motor - 11
Chamber Motor - 12

Conveyor Proximity Sensor - 0
Chamber Proximity Sensor - 1

**In the 2022 robot, both motors run "backwards", so moving a ball through the ball track means driving the motor with a negative percent output.**

#### Logic

The goal of this system is to efficiently and consistently store balls within the robot.

In a hypothetical scenario with two balls entering the robot, we want to stop the first ball once it reaches the chamber proximity sensor, and the second once it has been detected by the conveyor proximity sensor and when there is already a ball in the chamber.

There are three main scenarios we need to consider to make this possible.

1. Both proximity sensors detect a ball
2. Only the chamber proximity sensor detects a ball
3. Any other situation

From here, it is your task to create these additional motors and sensors, and to fill in the logic to enable ball storage in the robot.

Good luck!
