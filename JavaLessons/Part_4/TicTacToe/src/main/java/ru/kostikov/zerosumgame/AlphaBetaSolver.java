package ru.kostikov.zerosumgame;

import ru.kostikov.tictactoe.Field;
import ru.kostikov.tictactoe.Move;

import org.apache.log4j.Logger;
import ru.kostikov.tictactoe.Rules;

/**
 * Реализация альфа-бета процедуры.
 * 
 * @author dok
 * 
 */
public class AlphaBetaSolver extends Solver {

    private final Heuristic heuristic;

    private int maxDepth;

    private static final Logger LOG = Logger.getLogger(MiniMaxSolver.class);

    /**
     * Альфа-бета процедура. Выполнена как поиска максимального выигрыша (для поиска
     * минимального вызывается -alphaBeta).
     * 
     * @param field
     *            состояние игрового поля после хода.
     * @param move
     *            ход, который привел к оцениваемому состоянию.
     * @param player
     *            идентификатор игрока, для которого выполняется оценка.
     * @param alpha
     *            значение альфа
     * @param beta
     *            значение бета
     * @param depth
     *            текущаа глубина раскрытия дерева.
     * @return оценка хода.
     */
    public int alphaBeta(Field field, Move move, int player, int alpha, int beta,
            int depth) {
        if (field.isGameOver() || depth == maxDepth) {
            int score = heuristic.score(field, player, move);
            return score;
        }
        int score = Integer.MIN_VALUE;
        Move[] moves = rules.getMoves(player);
        for (Move m : moves) {
            field.doMove(m, player);
            int res = -alphaBeta(field, move, -player, -beta, -score, depth + 1);
            field.undoMove(m, player);
            score = (res > score) ? res : score;
            if (score > beta) {
                return score;
            }
        }
        return score;
    }

    /**
     * 
     * @param rules
     * @param player
     * @param field
     * @param heuristic
     * @param maxDepth
     */
    public AlphaBetaSolver(Rules rules, int player, Field field, Heuristic heuristic, int maxDepth) {
        super(rules, player, field);
        if (rules == null) {
            throw new IllegalArgumentException("Rules can`t be null.");
        }
        this.heuristic = heuristic;
        this.maxDepth = maxDepth;
        LOG.debug("AlphaBetaSolver created with " + heuristic.getClass().getName()
                + " heuristic.");
    }

    @Override
    protected int score(Field field, int player, Move m) {
        return -alphaBeta(field, m, player, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }

}
