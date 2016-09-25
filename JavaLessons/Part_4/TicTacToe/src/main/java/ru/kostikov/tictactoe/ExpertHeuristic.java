package ru.kostikov.tictactoe;

import ru.kostikov.tictactoe.Field;
import ru.kostikov.tictactoe.FieldScanner;
import ru.kostikov.tictactoe.FieldScanner.Line;
import ru.kostikov.tictactoe.FieldScanner.Score;
import ru.kostikov.tictactoe.Move;
import ru.kostikov.zerosumgame.Heuristic;

public class ExpertHeuristic implements Heuristic {

    public ExpertHeuristic(int player) {
        this.player = player;
    }
    @Override
    public int score(Field field, int player, Move m) {
        /* Оценка длины ряда для игрока */
        int res = 0;
        for (Line line : Line.values()) {
            Score score = FieldScanner.scoreLine(line, field.field, field.winLength, m,
                    player);
            if (score.investigated < field.winLength) {
                continue;
            }
            if (score.inrow >= field.winLength) {
                res = Integer.MAX_VALUE;
                return (player == this.player) ? res : -res;
            }
            res += G(score.inrow) + score.count;
        }
        /* Оценка длины ряда для противника */
        for (Line line : Line.values()) {
            Score score = FieldScanner.scoreLine(line, field.field, field.winLength, m,
                    -player);
            if (score.investigated < field.winLength) {
                continue;
            }
            res += Q(score.inrow) + score.count;
        }
        return (player == this.player) ? res : -res;
    }


    private int G(int k) {
        return f(k + 2);
    }

    private int Q(int k) {
        return f(k + 2);
    }

    private int f(int k) {
        if (k < 0) {
            throw new IllegalArgumentException();
        }
        if (k == 1)
            return k;
        return k * f(k - 1);
    }

    private final int player;
}
