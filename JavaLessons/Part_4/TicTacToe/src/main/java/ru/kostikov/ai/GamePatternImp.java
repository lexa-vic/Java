package ru.kostikov.ai;

import com.mifmif.common.regex.Generex;

import java.util.*;

/**
 * Created by user on 27.09.2016.
 */
public class GamePatternImp {

    /** Паттер и очки при совпадении */
    private class PatternScore{
        public String pattern;
        public int score;

        public PatternScore(String pattern, int score) {
            this.pattern = pattern;
            this.score = score;
        }
    }

    /** Массив паттерно игры с весом дл\ каждого*/
    private List<PatternScore> patterns = new ArrayList<>();

    /**
     * Конструктор, добавляем паттерны в зависимости от длинны выйгрышной комбинации и игрока
     * @param winLength
     * @param player
     */
    public GamePatternImp(int winLength, int player){

        if (winLength >= 3){
            // 10000, p: ['xxxxx']}, // Пять в ряд. Победа
            String p1 = String.format("%d{%d}", player, winLength);
            Generex generex = new Generex(p1);
            patterns.add(new PatternScore(generex.getFirstMatch(), 10000));

            // 1000, p: ['0xxxx0']}, // Открытая четверка. Один ход до победы, 100% победа (соперник не может закрыть одним ходом)
            p1 = String.format("0%d{%d}0", player, winLength-1);
            generex = new Generex(p1);
            patterns.add(new PatternScore(generex.getFirstMatch(), 1000));

            // 500, p: ['xxxx0']}, // Полузакрытая четверка. Один ход до победы, но соперник может заблокировать
            p1 = String.format("%d{%d}0", player, winLength-1);
            generex = new Generex(p1);
            patterns.add(new PatternScore(generex.getFirstMatch(), 500));

            // 500, p: ['xxxx0']}, // Полузакрытая четверка. Один ход до победы, но соперник может заблокировать
            p1 = String.format("%d{%d}0", player, winLength-1);
            generex = new Generex(p1);
            patterns.add(new PatternScore(generex.getFirstMatch(), 500));

            // 400, p: ['x0xxx']}, // Четверка с брешью. Один ход до победы, но соперник может заблокировать
            p1 = String.format("%d0%d{%d}", player, player, winLength-2);
            generex = new Generex(p1);
            patterns.add(new PatternScore(generex.getFirstMatch(),  400));

            if (winLength > 3){
                // 400, p: ['xx0xx']}, // Четверка с брешью. Один ход до победы, но соперник может заблокировать
                p1 = String.format("%d{%d}0%d{%d}",player,  winLength-3, player, winLength-3);
                generex = new Generex(p1);
                patterns.add(new PatternScore(generex.getFirstMatch(), 400));
            }
            //100, p: ['00xxx000']}, // Открытая тройка (как 2 полузакрытых)
            p1 = String.format("00%d{%d}000",player,  winLength-2);
            generex = new Generex(p1);
            patterns.add(new PatternScore(generex.getFirstMatch(), 100));

            //80, p: ['00xxx00']}, // Открытая тройка (как 2 полузакрытых)
            p1 = String.format("00%d{%d}00",player,  winLength-2);
            generex = new Generex(p1);
            patterns.add(new PatternScore(generex.getFirstMatch(), 80));

            // 75, p: ['0xxx00']}, // Открытая тройка (как 2 полузакрытых)
            p1 = String.format("0%d{%d}00",player,  winLength-2);
            generex = new Generex(p1);
            patterns.add(new PatternScore(generex.getFirstMatch(), 75));

            // 50, p: ['0xxx0','xxx00']}, // Полузакрытая тройка
            p1 = String.format("0%d{%d}0",player,  winLength-2);
            generex = new Generex(p1);
            patterns.add(new PatternScore(generex.getFirstMatch(), 50));

            if (winLength > 3) {
                // 25, p: ['x0xx0', 'xx0x0', 'x00xx']}, // Тройка с брешью
                p1 = String.format("%d0%d{%d}0",player, player, winLength - 3);
                generex = new Generex(p1);
                patterns.add(new PatternScore(generex.getFirstMatch(), 50));

                p1 = String.format("%d{%d}0%d0", player, winLength - 3, player);
                generex = new Generex(p1);
                patterns.add(new PatternScore(generex.getFirstMatch(), 50));

                p1 = String.format("%d00%d{%d}", player, player, winLength - 3);
                generex = new Generex(p1);
                patterns.add(new PatternScore(generex.getFirstMatch(), 50));
            }
            if (winLength > 4) {
                // 10, p: ['000xx000']}, // Открытая двойка
                p1 = String.format("000%d{%d}000", player, player, winLength - 3);
                generex = new Generex(p1);
                patterns.add(new PatternScore(generex.getFirstMatch(), 50));

                // 5, p: ['0xx0']} // Открытая двойка
                p1 = String.format("0%d{%d}0", player, player, winLength - 3);
                generex = new Generex(p1);
                patterns.add(new PatternScore(generex.getFirstMatch(), 50));
            }

        }

    }

    public int getLineScore(String line){
        for (PatternScore pattern: patterns){
            if (line.contains(pattern.pattern)){
                return pattern.score;
            }
        }
        return 0;
    }
}
