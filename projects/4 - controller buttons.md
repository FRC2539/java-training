# Controller Buttons

In our last "basic components" section, we will use a button input to control our robot.

The previous section had an optional project, and the solution for this project will build on that, but the logic is approximately the same for the basic sensor example.

The optional project created a system called the "ball track", which makes it easier to explain the usage of buttons, and thus I would recommend at least reading the contents of the optional project before continuing with this project.

### Why use buttons?

Controllers, and their buttons, are our main way of controlling our robot, and thus it is imperative that we can receive and use signals from these devices.

Controllers also have "axes", which can be used when driving the robot (an axis returns a value from -1 to 1).

### The Task

_Note: this project will require use of the WPILIB Java Documentation._

As of right now, the ball track on our robot runs continuously as soon as the robot is enabled, and only stops when we disable. This is great for a demo, but in a real match, this would rapidly drain the battery on the robot.

Your task is to use a joystick button to control the ball track. The ball track should only run when a given button is pressed, and otherwise, it should stop.

#### Important information

**Ports**
_These ports are for the 2022 robot controllers; ask a trustworthy programmer for the correct ports and numbers if you are not using this robot._

-   Joystick - 0 (Left Thrustmaster Joystick)
-   JoystickButton - 3 (Left Thumb Button)

#### Final notes

For better organization, I would recommend encapsulating long logic (such as that for the ball track) as well as repeated code in separate functions in the `Robot` class.
