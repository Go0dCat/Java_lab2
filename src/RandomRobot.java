import java.util.ArrayList;
/**
 * An object representing a robot choosing a random path
 * Contains a position, a previous posution and map located within
 */
public class RandomRobot {
    /**
     * Using two positions to recall last position and the maze the positions are active within
     */
    private Position p;
    private Position prevP;
    private Maze m;

    /**
     * Reads a maze from input to create a starting position
     * @param m for the maze to be located within
     */
    public RandomRobot(Maze m) {
        this.m = m;
        this.p = m.getStart();
        this.prevP = this.p;
    }
    /**
     * Moves robots position i {@code maze}. Will primarily target the goal,
     * secondly choose a new path and otherwise return to previous position
     */
    public void move() {
        int min = 0;
        int max = 0;
        int x = m.getNumColumns();
        int y = m.getNumRows();
        boolean foundGoal = false;

        Position pEast = new Position(p.getPosToEast());
        Position pWest = new Position(p.getPosToWest());
        Position pNorth = new Position(p.getPosToNorth());
        Position pSouth = new Position(p.getPosToSouth());

        ArrayList<Position> arrPos = new ArrayList<>();


        //checks which positions are movable and not the previous location
        if(pEast.getX() < m.getNumColumns()) {
            if(m.isGoal(pEast)) {
                foundGoal = true;
                this.prevP = this.p;
                this.p = pEast;
            } else {
                if(m.isMovable(pEast) && !prevP.equals(pEast)) {
                    max++;
                    arrPos.add(pEast);
                }
            }
        }

        if(pWest.getX() > 0) {
            if(m.isGoal(pWest)) {
                foundGoal = true;
                this.prevP = this.p;
                this.p = pWest;
            } else {
                if(m.isMovable(pWest) && !prevP.equals(pWest)) {
                    max++;
                    arrPos.add(pWest);
                }
            }
        }

        if( pNorth.getY() > 0) {
            if(m.isGoal(pNorth)) {
                foundGoal = true;
                this.prevP = this.p;
                this.p = pNorth;
            } else {
                if(m.isMovable(pNorth) && !prevP.equals(pNorth)) {
                    max++;
                    arrPos.add(pNorth);
                }
            }
        }

        if( pSouth.getY() < m.getNumRows()) {
            if(m.isGoal(pSouth)) {
                foundGoal = true;
                this.prevP = this.p;
                this.p = pSouth;
            } else {
                if(m.isMovable(pSouth) && !prevP.equals(pSouth)) {
                    max++;
                    arrPos.add(pSouth);
                }
            }
        }
        //checks if already moved to goal
        if(!foundGoal) {
            //checks available new paths
            if(max <= 0) {
                if (p.equals(prevP)) {
                    System.out.println("The robot cannot move from start, please provide another maze");
                    System.exit(0);
                } else {
                    Position p2 = new Position(this.p);
                    this.p = this.prevP;
                    this.prevP = p2;
                }
            //moves based on a random choise between two paths
            } else {
                int rand = min + (int) (Math.random() * ((max-min) + min));
                this.prevP = this.p;
                this.p = arrPos.get(rand);
            }
        }

    }
    /**
     * Prints robots position in maze tp system output by turning the {@code Maze} into a char matrix
     */
    public void printMaze() {
        char[][] mapMatrix = new char[m.getNumRows()][m.getNumColumns()];
        for(int i=0; i<m.getNumRows();i++) {
            for (int j = 0; j < m.getNumColumns(); j++) {
                mapMatrix[i][j] = m.getMap().get(i)[j];
                if(p.getY() == i && p.getX() == j) {
                    mapMatrix[i][j] = 'R';
                }
                System.out.print(mapMatrix[i][j]);
            }
            System.out.println(" ");
        }
    }

    /**
     * Gets current position of robot
     *
     * @return the current {@code Position}
     */
    public Position getPosition() {
        return this.p;
    }
    /**
     * Sets current position of robot
     * @param p the position to be used
     */
    private void setPosition(Position p) {
        this.prevP = this.p;
        this.p = p;
    }

    /**
     * Gets if current position of robot is locadet on goal
     *
     * @return true if {@code Position} is the goal, otherwise false
     */
    public boolean hasReachedGoal() {
        return m.isGoal(this.p);
    }
}
