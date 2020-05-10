import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * An arrayList containing char-arrays representing a map in format {@code ArrayList<char[]>} as a coordinate space.
 * Can contain "*", "S", "M" and " ".
 */
public class Maze {
    /**
     * Using a cordinate arrayList with a char-array system for map positioning.
     */
    private ArrayList<char[]> map = new ArrayList<>();
    private Position start;


    /**
     * Reads a mazemap from a given filepath containing
     * {start: "S"; goal: "G"; wall: "*"; path: " "} as a
     *  {@code map} representing a char matrix.
     * @param filepath for the map to be read in
     */
    public Maze(Reader filepath) {
        Scanner s=new Scanner(filepath);
        while(s.hasNextLine()) {
            String str = s.nextLine();
            char[] ch = new char[str.length()];
            for (int i = 0; i < str.length(); i++) {
                ch[i] = str.charAt(i);
            }
            map.add(ch);
        }
        //used for visual  test
        /*
        for(int i=0; i<map.size();i++) {
            System.out.print(map.get(i));
            System.out.println(map.get(i).length);
        }
        */

        boolean hasStart = false;
        boolean hasGoal = false;
        boolean isOkay = true;

        for(int i=0; i<map.size();i++) {
            for (int j = 0; j < map.get(i).length; j++) {
                char c = map.get(i)[j];
                if (Character.compare('S', c) == 0) {
                    hasStart = true;
                    start = new Position(i,j);
                }
                if (Character.compare('G', c) == 0) {
                    hasGoal = true;
                }
                if (Character.compare(' ', c) == 0 || Character.compare('*', c) == 0 || Character.compare('S', c) == 0 || Character.compare('G', c) == 0) {

                } else {
                    isOkay = false;
                }
            }
        }

        if(hasStart == true && hasGoal == true && isOkay == true) {
        } else {
            System.out.println("Please enter a correct maze as input");
            System.exit(0);
        }
    }
    /**
     * Returns true if this {@code Position} is a path
     *
     * @return true if {@code (x,y) == ' '}, otherwise false
     */
    public boolean isMovable(Position p) {
        char c = map.get(p.getY())[p.getX()];
        if (Character.compare(' ', c) == 0) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Returns true if this {@code Position} is the goal
     *
     * @return true if {@code (x,y) == 'G'}, otherwise false
     */
    public boolean isGoal(Position p) {
        char c = map.get(p.getY())[p.getX()];
        if (Character.compare('G', c) == 0) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Returns the position of {@code start}
     *
     * @return the {@code Position} of the {@code (x,y) == 'S'}
     */
    public Position getStart() {
        return start;
    }

    /**
     * Returns the width of {@code map}
     *
     * @return the length of first row in arraylist {@code map}
     */
    public int getNumColumns() {
        return map.get(0).length;
    }
    /**
     * Returns the height of {@code map}
     *
     * @return the nummer of entries in arraylist {@code map}
     */
    public int getNumRows() {
        return map.size();
    }

    /**
     * Returns an ArrayList that represents the value of this {@code map},
     *
     * @return an ArrayList representation of this {@code map}.
     */
    public ArrayList<char[]> getMap() {
        return map;
    }

    /**
     * Returns a bool that represents if this {@code map}, equals param
     * @param o the object to be compared
     *
     * @return a boolean representation if this {@code map} equals o, otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Maze maze = (Maze) o;
        return Objects.equals(map, maze.map);
    }

    /**
     * Returns an int with calculated hash of this {@code map}
     *
     * @return an int representation a hash of this {@code map}
     */
    @Override
    public int hashCode() {
        return Objects.hash(map);
    }
}
