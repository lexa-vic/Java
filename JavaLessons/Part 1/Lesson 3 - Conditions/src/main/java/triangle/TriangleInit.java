package triangle;

/**
 * Created by Алексей on 08.07.2016.
 */
public class TriangleInit {

    public static void main(String[] args) {

        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(2, 2);

        System.out.printf("Distance p1 p2 = %f\n", p1.distanceTo(p2));

        Triangle triangle = new Triangle(p1, p2, p3);

        System.out.printf("Triangle area is %f\n", triangle.area());
    }
}
