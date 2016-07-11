package equation;

/**
 * Created by Алексей on 11.07.2016.
 */
public class SquareInit {

    public static void main(String[] args) {
        /** Коэффициенты уравнения */
        double a = 0, b = 0, c = 0;
        /** Отрехок на которов расчитывается функция */
        double x1, x2;
        /** Шаг расчета */
        double step;

        if (args.length == 6)
        {
            a = Double.valueOf(args[0]);
            b = Double.valueOf(args[1]);
            c = Double.valueOf(args[2]);

            x1   = Double.valueOf(args[3]);
            x2   = Double.valueOf(args[4]);
            step = Double.valueOf(args[5]);

            if (a == 0){

                System.out.println("Enter correct argumets: a != 0");
            }
            else{

                Square func = new Square(a, b, c);

                while(x1 <= x2)
                {
                    System.out.printf("Func(%.3f): %.3f \n", x1, func.calculate(x1));
                    x1 += step;
                }

            }
        }else{

            System.out.println("Enter all argumets: a, b, c, x1, x2, step");
        }










    }
}
