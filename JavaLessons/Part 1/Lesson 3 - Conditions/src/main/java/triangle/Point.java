package triangle;

import static java.lang.Math.*;

/**
 * Created by Алексей on 08.07.2016.
 */
public class Point {
    /** Координата x */
    public double x;
    /** Координата y */
    public double y;

    /**
     * @param x Координата x
     * @param y Координата y
     */
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Расчет дистанции текущей точки до указанной в параметре
     * @param b Точка до которой считаем дистанцию
     * @return Дистанция
     */
    public double distanceTo(Point b){

        double dist = 0;

        // Расстояние между точками - корень из суммы квадратов разностей координат
        dist = sqrt(pow((b.x - this.x), 2) + pow((b.y - this.y), 2));
        return dist;
    }
}

