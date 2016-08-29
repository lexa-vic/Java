package triangle;

import static java.lang.Math.*;

/**
 * The class implements a point in the triangle.
 * Created by Алексей on 08.07.2016.
 */
public class Point {
    /** The x coordinate */
    public double x;
    /** The y coordinate */
    public double y;

    /**
     * Constructor.
     * @param x x-coordinate.
     * @param y y-coordinate.
     */
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Calculates distance from current point to the point in argument.
     * @param b The end point.
     * @return Result distance.
     */
    public double distanceTo(Point b){

        double dist = 0;

        dist = sqrt(pow((b.x - this.x), 2) + pow((b.y - this.y), 2));
        return dist;
    }
}

