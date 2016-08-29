package triangle;

/**
 * Main class creates the triangle and calculate it max side.
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

        MaxSide maxSide  = new MaxSide();
        double  maxValueAB = maxSide.max(triangle.getSideA(), triangle.getSideB());
        double  maxValueBC = maxSide.max(triangle.getSideB(), triangle.getSideC());

        if (maxValueAB > maxValueBC){

            System.out.printf("Triangle max side is %f\n", maxValueAB);
        }else {
            System.out.printf("Triangle max side is %f\n", maxValueBC);
        }


    }

}
