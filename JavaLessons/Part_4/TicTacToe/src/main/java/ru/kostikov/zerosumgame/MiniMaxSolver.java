package ru.kostikov.zerosumgame;


import org.apache.log4j.Logger;

import ru.kostikov.tictactoe.Field;
import ru.kostikov.tictactoe.Move;
import ru.kostikov.tictactoe.Rules;

/**
 * Выполняет выбор наилучшего хода с помощью минимаксной процедуры.
 * 
 * @author dok
 * 
 */
public class MiniMaxSolver extends Solver{

    private int maxDepth;

    private final Heuristic heuristic;

    private static final Logger LOG = Logger.getLogger(MiniMaxSolver.class);
    /**
     * {@inheritDoc}
     */
    @Override
    protected int score(Field field, int player, Move m) {
        return min(field, m, player, 1);
    }

    public int max(Field field, Move m, int player, int depth) {
        if (field.isGameOver() || depth == maxDepth) {
            int score = heuristic.score(field, player, m);
            return score;
        }
        int score = Integer.MIN_VALUE;
        Move[] moves = rules.getMoves(player);
        for (Move move : moves) {
            field.doMove(move, player);
            int res = min(field, move, -player, depth + 1);
            field.undoMove(move, player);
            score = (res > score) ? res : score;
        }
        return score;
    }

    public int min(Field field, Move m, int player, int depth) {
        if (field.isGameOver() || depth == maxDepth) {
            int score = -heuristic.score(field, player, m);
            return score;
        }
        int score = Integer.MAX_VALUE;
        Move[] moves = rules.getMoves(player);
        for (Move move : moves) {
            field.doMove(move, player);
            int res = max(field, move, -player, depth + 1);
            field.undoMove(move, player);
            score = (res < score) ? res : score;
        }
        return score;
    }

    /**
     * 
     * @param rules
     * @param player
     * @param field
     * @param heuristic
     *            объект для эвристической оценки состояния игрового поля.
     * @param maxDepth
     */
    public MiniMaxSolver(Rules rules, int player, Field field,
                         Heuristic heuristic, int maxDepth) {
        super(rules, player, field);
        if (rules == null) {
            throw new IllegalArgumentException("Rules can`t be null.");
        }
        this.heuristic = heuristic;
        this.maxDepth = maxDepth;
        LOG.debug("MiniMaxSolver created with " + heuristic.getClass().getName()
                + " heuristic.");
    }
}
