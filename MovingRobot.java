
public class MovingRobot extends BaseRobot {
    private String direction;

    public MovingRobot(String id, int batteryLevel,
                       String direction) {
        super(id, batteryLevel);
        this.direction = direction;
    }

    public void drive() {
        drive(5, direction);
    }

    // Method overloading: speed and direction
    public void drive(int speed, String direction) {
        if (!isRunning()) {
            throw new IllegalStateException(
                "Start the robot before driving."
            );
        }

        if (speed <= 0) {
            throw new IllegalArgumentException(
                "Speed must be positive."
            );
        }

        if (direction == null || direction.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Direction cannot be empty."
            );
        }

        consumeBattery(10);
        this.direction = direction;

        System.out.println(
            getId() + " driving at " + speed
            + " km/h towards " + direction + "."
        );
    }

    @Override
    public void performTask() {
        drive();
    }

    @Override
    public void status() {
        super.status();
        System.out.println("Direction: " + direction);
    }
}
