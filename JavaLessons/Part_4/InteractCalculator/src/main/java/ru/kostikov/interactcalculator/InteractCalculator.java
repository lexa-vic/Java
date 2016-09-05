package ru.kostikov.interactcalculator;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class implements fluent calculator which support enter a mathematical expression,
 * different math functions and other.
 * Created by Алексей on 03.09.2016.
 */
public class InteractCalculator {

    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private MathCalc mathCalc;

    public InteractCalculator(MathCalc mathCalc){
        this.mathCalc = mathCalc;
    }

    public void userInterract(){
        String inputStr = "";
        while(true){
            System.out.println("Введите математическое выражение. Для выходы введите: q ");

            try {
                inputStr = this.input.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(!inputStr.equals("q")){
                try {
                    System.out.format("Результат: %.2f\n", this.mathCalc.calc(inputStr)) ;
                }catch (ParseBracketsExpetion pbe){
                    System.out.println("Пропущена скобка.");
                }catch (ParseUndefineTokenExpetion pute){
                    System.out.println("Неизвестная функция.");
                }catch (MathParseExeptions mpe){
                    System.out.println("Ошибка выражения.");
                }catch (ArithmeticException ae){
                    System.out.println("Деление на ноль.");
                }
            }else
            {
                break;
            }
        }
    }

    public static void main(String[] args) {
        InteractCalculator interactCalculator = new InteractCalculator(new MathCalc(new EngineerCalculator()));

        interactCalculator.userInterract();


    }
}
