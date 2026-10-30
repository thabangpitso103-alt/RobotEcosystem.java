
public class Main {
    public static void main(String[] args) {
        try {
            FlyingRobot flying =
                new FlyingRobot("FR01", 80, 20);

            MovingRobot moving =
                new MovingRobot("MR01", 70, "North");

            WalkingRobot walking =
                new WalkingRobot("WR01", 90, 0);

            RobotController controller = new RobotController();

            controller.addRobot(flying);
            controller.addRobot(moving);
            controller.addRobot(walking);

            System.out.println("\n--- Starting Robots ---");
            controller.startAll();

            System.out.println("\n--- Performing Tasks ---");
            controller.performAllTasks();

            System.out.println("\n--- Overloading Demo ---");
            flying.fly(50);
            moving.drive(15, "East");
            walking.walk(20);
            walking.avoidObstacle();

            System.out.println("\n--- Robot Status ---");
            controller.showAllStatus();

            System.out.println("\n--- Stopping Robots ---");
            controller.stopAll();

        } catch (IllegalArgumentException | IllegalStateException | RobotException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
