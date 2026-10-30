
import java.util.ArrayList;
import java.util.List;

public class RobotController {
    private List<Robot> robots;

    public RobotController() {
        robots = new ArrayList<>();
    }

    public void addRobot(Robot robot) {
        if (robot == null) {
            throw new IllegalArgumentException(
                "Robot cannot be null."
            );
        }

        robots.add(robot);
        System.out.println("Robot added to controller.");
    }

    public void startAll() {
        for (Robot robot : robots) {
            try {
                robot.start();
            } catch (IllegalStateException e) {
                System.out.println("Start error: " + e.getMessage());
            }
        }
    }

    public void stopAll() {
        for (Robot robot : robots) {
            robot.stop();
        }
    }

    public void showAllStatus() {
        for (Robot robot : robots) {
            robot.status();
            System.out.println("--------------------");
        }
    }

    public void performAllTasks() {
        for (Robot robot : robots) {
            try {
                ((BaseRobot) robot).performTask();
            } catch (IllegalStateException | RobotException e) {
                System.out.println("Task error: " + e.getMessage());
            }
        }
    }
}
