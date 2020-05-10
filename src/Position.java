import java.util.Objects;

/**
 * A point representing a location in {@code (x, y)} coordinate space,
 * specified in integer precision.
 */
public class Position {
    /**
     * Mutable by design - opt for modifying a position rather than
     * creating a new one.
     */
    private int x;
    private int y;

    /**
     * Constructs and initializes a point at the specified
     * {@code (x, y)} location in the coordinate space.
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Creates a copy of the given position.
     * @param p The Position to copy.
     * @throws NullPointerException If the given position is null.
     */
    public Position(Position p) {
        this.x = p.x;
        this.y = p.y;
    }

    /**
     * Returns the x-coordinate of this {@code Position}
     * in integer precision.
     * @return the x-coordinate of this {@code Position}
     */
    public int getX() {
        return this.x;
    }

    /**
     * Returns the y-coordinate of this {@code Position}
     * in integer precision.
     *
     * @return the y-coordinate of this {@code Position}
     */
    public int getY() {
        return this.y;
    }

    /**
     * Sets the x-coordinate of this {@code Position}
     * in integer precision.
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * Sets the y-coordinate of this {@code Position}
     * in integer precision.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets the coordinate south of this {@code (x, y)} location
     *
     * @return the coordinate (x, y+1) of this {@code Position}
     */
    public Position getPosToSouth() {
        return new Position(this.x, this.y+1);
    }

    /**
     * Gets the coordinate north of this {@code (x, y)} location
     *
     * @return the coordinate (x, y-1) of this {@code Position}
     */
    public Position getPosToNorth() {
        return new Position(this.x, this.y-1);
    }

    /**
     * Gets the coordinate west of this {@code (x, y)} location
     *
     * @return the coordinate (x-1, y) of this {@code Position}
     */
    public Position getPosToWest() {
        return new Position(this.x-1, this.y);
    }

    /**
     * Gets the coordinate east of this {@code (x, y)} location
     *
     * @return the coordinate (x+1, y) of this {@code Position}
     */
    public Position getPosToEast() {
        return new Position(this.x+1, this.y);
    }


    /**
     * Returns a String that represents the value of this {@code Position}, , "(x, y)"
     *
     * @return a string representation of this {@code Position}.
     */
    @Override
    public String toString() {

        return "("+x+","+y+")";
    }

    /**
     * Returns a bool that represents if this {@code Position}, equals param
     * @param o the object to be compared
     *
     * @return a boolean representation if this {@code Position} equals o, otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    /**
     * Returns an int with calculated hash of this {@code Position}
     *
     * @return an int representation a hash of this {@code Position}
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
