# Running a Motor

_Given that this requires a robot, these steps need to be supplemented by actual interaction between you and the lead programmer/programming mentor._

For this example, we will be controlling a motor (Talon SRX) at a percent output (-1 to 1).

### 1. Installing libraries

See [this page](https://docs.wpilib.org/en/stable/docs/software/vscode-overview/3rd-party-libraries.html#rd-party-libraries) for a link to many of the latest third party libaries.

Copy the link for the CTRE Phoenix Framework from the page linked above.

Now, in your project, click the W (WPILIB) icon at the top right, and type "Manage Vendor Libraries".

Select that, and then press "Install new library (online)"

Paste the link you copied, and press enter. It may ask you to build the project, and allow it to do so. If there is a problem, either try to debug it, or ask the lead programmer, the programming mentor, or another experienced programmer.

### 2. Cleaning up the code

Open `Robot.java` in _src/main/java/frc/robot_.

1. Delete the two imports that are related to smart dashboard.
2. Delete the first four lines within the `Robot` class.
3. Delete the contents of `robotInit`, `autonomousInit`, and `autonomousPeriodic`.
4. Delete any comments that you find bothersome

### 3. Instantiating the motor object

First, import `WPI_TalonSRX` by typing `import`, and then as you type `WPI_TalonSRX`, use the auto complete to import the correct class (press enter on the correct class).

Right below the `Robot` class declaration, we will instatiate our motor.

Type `private WPI_TalonSRX motor = new WPI_TalonSRX(11);`

**Note: the parameter passed to the constructor is the port of the motor. If this is not 2022, this port is likely different, so ask a trustworthy member of the programming team for the correct information.**

Congratulations! You have now created your first motor controller object!

### 4. Setting the motor output

In `teleopInit`, type `motor.set(0.3);`. This will set the motor to run forward at 30%.

Next, type `motor.stopMotor();` in `disabledInit`. This will stop the motor whenever we disable the robot.

### 5. Testing your code

**Make sure that you are being supervised by a trustworthy programmer when you test your code.**

Now, connect to the robot wifi, click the W (WPILIB) icon at the top right of VSCode, and select "Deploy Robot Code".

If you need assistance with this, talk to a trustworthy member of the programming team.

Finally, test the code by enabling the robot, and if everything is correct, the motor should be spinning. When you are satisfied, click disable (or press enter), which will disable the robot.

Nice job!
