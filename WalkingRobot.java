public class WalkingRobot extends BaseRobot {
    private int totalSteps;

    public WalkingRobot(String id, int batteryLevel, int totalSteps) {
        super(id, batteryLevel);
        if (totalSteps < 0) {
            throw new IllegalArgumentException(
                "Steps cannot be negative."
            );
        }
        this.totalSteps = totalSteps;
    }

    public void walk() throws RobotException {
        walk(10);
    }

    // Method overloading: walk a custom number of steps
    public void walk(int steps) throws RobotException {
        if (!isRunning()) {
            throw new RobotException("Start the robot before walking.");
        }
        if (steps <= 0) {
            throw new IllegalArgumentException(
                "Steps must be greater than zero."
            );
        }

        consumeBattery(20);
        totalSteps += steps;

        System.out.println(getId() + " is walking " + steps + " steps.");
    }

    public void avoidObstacle() throws RobotException {
        if (!isRunning()) {
            throw new RobotException(
                "Start the robot before avoiding obstacles."
            );
        }

        consumeBattery(10);
        System.out.println(getId() + " has successfully avoided an obstacle.");
    }

    @Override
    public void performTask() throws RobotException {
        walk();
    }

    @Override
    public void status() {
        super.status();
        System.out.println("Total steps: " + totalSteps);
    }
}
