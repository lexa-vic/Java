package ru.kostikov.zerosumgame;

import com.mifmif.common.regex.Generex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 27.09.2016.
 */
public class GamePatternImp {

    public GamePatternImp(int winLength, int player){
        //['xxxxx']}, // Пять в ряд. Победа
        String string = String.format("x{%d}", 0);
        Generex generex = new Generex(string);

        String str = generex.getFirstMatch();

        System.out.println(str);

    }

    public int getLineScore(){
        return 0;
    }

    public static void main(String[] args) {
        GamePatternImp g = new GamePatternImp(5, 2);
    }
}
