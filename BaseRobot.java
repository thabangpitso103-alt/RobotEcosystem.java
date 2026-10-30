public abstract class BaseRobot implements Robot {
    private final String id;
    private int batteryLevel;
    private boolean running;

    public BaseRobot(String id, int batteryLevel) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Robot id cannot be empty.");
        }
        if (batteryLevel < 0 || batteryLevel > 100) {
            throw new IllegalArgumentException(
                "Battery level must be between 0 and 100."
            );
        }
        this.id = id;
        this.batteryLevel = batteryLevel;
    }

    public String getId() {
        return id;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public boolean isRunning() {
        return running;
    }

    protected void consumeBattery(int amount) {
        if (batteryLevel < amount) {
            throw new IllegalStateException(
                id + " has insufficient battery."
            );
        }
        batteryLevel -= amount;
    }

    @Override
    public void start() {
        if (running) {
            throw new IllegalStateException(id + " is already running.");
        }
        if (batteryLevel <= 0) {
            throw new IllegalStateException(
                id + " cannot start: battery empty."
            );
        }
        running = true;
        System.out.println(id + " started.");
    }

    @Override
    public void stop() {
        if (running) {
            running = false;
            System.out.println(id + " stopped.");
        } else {
            System.out.println(id + " is already stopped.");
        }
    }

    @Override
    public void status() {
        System.out.println("Robot ID: " + id
            + " | Battery: " + batteryLevel + "%"
            + " | Running: " + running);
    }

    public abstract void performTask() throws RobotException;
}
