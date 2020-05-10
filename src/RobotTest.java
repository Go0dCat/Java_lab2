import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

/**
 * An test using a robot choosing a random path through a maze
 */
public class RobotTest {
    /**
     * Main for the test
     * @param args needs to contain a filepath for maze file as first argument
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(args[0]);
        Reader filepath = new FileReader(args[0]);
        Maze m = new Maze(filepath);
        RandomRobot robot = new RandomRobot(m);
        int i = 0;

        System.out.println("Starting position:");
        robot.printMaze();

        do {
            robot.move();
            i++;
            System.out.println("Turn " + i);
            robot.printMaze();
            System.out.println(" ");
            if (i > 1000) {
                System.out.println("I think it's time to call quits, this maze is unsolvable");
                System.exit(0);
            }

        } while (!robot.hasReachedGoal());

        System.out.println("Congratulations! It took " + i + " turns to clear the maze");
    }


}
