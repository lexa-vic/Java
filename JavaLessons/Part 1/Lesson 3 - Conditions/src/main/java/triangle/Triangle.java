package triangle;

import static java.lang.Math.*;

/**
 * Created by Алексей on 08.07.2016.
 */
public class Triangle {
    /** Вершины треугольника */
    private final Point a;
    private final Point b;
    private final Point c;
    // Стороны треугольника
    double ab, bc, ac;

    /**
     * Конструктор с добавлением вершин треугольника
     * @param a
     * @param b
     * @param c
     */
    Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }


    /**
     * Расчет площади треугольника
     * @return Площадь; -1 - если такой треугольник не существует
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
     * Длина стороны А
     * @return
     */
    public double getSideA(){
        return this.a.distanceTo(this.b);
    }

    /**
     * Длина стороны B
     * @return
     */
    public double getSideB(){
        return this.b.distanceTo(this.c);
    }
    /**
     * Длина стороны С
     * @return
     */
    public double getSideC(){
        return this.a.distanceTo(this.c);
    }

    /**
     * Максимальная длина стороны
     * @return Длина стороны ; -1 - если такой треугольник не существует
     */
/*
    public double max(){
        // Стороны треугольника
        double ab, bc, ac;
        double result = 0;

        ab = a.distanceTo(b);
        bc = b.distanceTo(c);
        ac = a.distanceTo(c);

        // Условие существование треугольника - сумма любых двух сторон больше третей
        if ((ab+bc) > ac) {
            if (ab >= bc && ab >= ac) {

                result = ab;
            } else if ((bc >= bc && bc >= ac)){

                result = bc;
            }
            else{

                result = ac;
            }
        }else{
            // Такой треугольник не существует
            result = -1;
        }
        return result;
    }
*/
}
