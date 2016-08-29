package triangle;

import static java.lang.Math.*;

/**
 * The class implements a triangle and calculates it area.
 * Created by Алексей on 08.07.2016.
 */
public class Triangle {
    /** The vertices of the triangle. */
    private final Point a;
    private final Point b;
    private final Point c;
    // Стороны треугольника
    double ab, bc, ac;

    /**
     * Constructor. Adds the vertices of the triangle.
     * @param a Vertex A.
     * @param b Vertex B.
     * @param c Vertex C.
     */
    Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    /**
     * Calculate the trinagle area
     * @return Area; -1 if this triangel not exists
     */
    public double area(){
        double result = 0;

        this.ab = getSideA();
        this.bc = getSideB();
        this.ac = getSideC();

        // Условие существование треугольника - сумма любых двух сторон больше третей
        if ((ab+bc) > ac)
        {
            double half_perim = (ab+bc+ac)/2;

            result = sqrt(half_perim*(half_perim-ab)*(half_perim-ac)*(half_perim-bc));

        }else{
            // Такой треугольник не существует
            result = -1;
        }
        return result;
    }

    /**
     * Length of side A
     * @return length
     */
    public double getSideA(){
        return this.a.distanceTo(this.b);
    }

    /**
     * Length of side B
     * @return
     */
    public double getSideB(){
        return this.b.distanceTo(this.c);
    }
    /**
     * Length of side C
     * @return
     */
    public double getSideC(){
        return this.a.distanceTo(this.c);
    }
}
