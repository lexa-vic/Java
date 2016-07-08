package triangle;

import static java.lang.Math.*;

/**
 * Created by Алексей on 08.07.2016.
 */
public class Triangle {

    private final Point a;
    private final Point b;
    private final Point c;

    Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Периметр треугольника
     * @return
     */
    private double perimeter(){
        return -1;
    }

    /**
     * Расчет площади треугольника
     * @return -1 - если такой треугольник нечуществует
     */
    public double area(){
        // Стороны треугольника
        double ab, bc, ac;
        double result = 0;

        ab = a.distanceTo(b);
        bc = b.distanceTo(c);
        ac = a.distanceTo(c);

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

}
