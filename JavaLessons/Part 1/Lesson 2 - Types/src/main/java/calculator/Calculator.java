package calculator;

/**
 * Created by Алексей on 06.07.2016.
 */
public class Calculator{

    /** Результат операций*/
    private double result;

    /**
     *	Сложение
     *	@param first  - первый аргумент
     *	@param second - второй аргумент
     */
    public void add(double first, double second){
        this.result = first+second;
    }
    /**
     *	Вычитание
     *	@param first  - первый аргумент
     *	@param second - второй аргумент
     */
    public void subtract(double first, double second){
        this.result = first-second;
    }
    /**
     *	Деление
     *	@param first  - первый аргумент
     *	@param second - второй аргумент
     */
    public void div(double first, double second){
        this.result = first/second;
    }

    /**
     *	Умножение
     *	@param first  - первый аргумент
     *	@param second - второй аргумент
     */
    public void mult(double first, double second){
        this.result = first*second;
    }

    /**
     *	Вывод результата
     *	@return Результат оперции
     */
    public double getResult()
    {
        return this.result;
    }
}
