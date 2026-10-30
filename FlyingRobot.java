
public class FlyingRobot extends BaseRobot {
    private int altitude;

    public FlyingRobot(String id, int batteryLevel, int altitude) {
        super(id, batteryLevel);

        if (altitude < 0) {
            throw new IllegalArgumentException(
                "Altitude cannot be negative."
            );
        }

        this.altitude = altitude;
    }

    public void fly() {
        fly(10);
    }

    // Method overloading: fly with a custom altitude
    public void fly(int newAltitude) {
        if (!isRunning()) {
            throw new IllegalStateException(
                "Start the robot before flying."
            );
        }

        if (newAltitude < 0) {
            throw new IllegalArgumentException(
                "Altitude cannot be negative."
            );
        }

        consumeBattery(10);
        altitude = newAltitude;

        System.out.println(
            getId() + " flying at " + altitude + " metres."
        );
    }

    @Override
    public void performTask() {
        fly();
    }

    @Override
    public void status() {
        super.status();
        System.out.println("Altitude: " + altitude + " metres.");
    }
}
