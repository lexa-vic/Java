package triangle;

/**
 * Created by Алексей on 10.07.2016.
 */
public class MaxSide {

    /**
     * Поиск большей из дву сторон треугольника
     * @param a
     * @param b
     * @return
     */
    public double max(double a, double b){
        return (a >= b ? a : b);
    }
}
