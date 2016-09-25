package ru.kostikov.zerosumgame;

import org.apache.log4j.Logger;

import ru.kostikov.tictactoe.Field;
import ru.kostikov.tictactoe.Move;
import ru.kostikov.tictactoe.Rules;

/**
 * Определяет лучший ход в играх с нулевой суммой.
 * 
 * @author dok
 * 
 */
public abstract class Solver {
    protected final Rules rules;

    protected final int player;

    protected final Field field;

    private static final Logger LOG = Logger.getLogger(Solver.class);

    /**
     * Создает объект для оценки выбора наилучшего хода в игре Крестики-нолики.
     *
     * @param rules
     *            реализация правил игры, для перебора всех возможных вариантов ходов.
     * @param player
     *            идентифиактор игрока, для которого выбирается ход.
     * @param field
     *            объект, описывающий игровое поле.
     */
    public Solver(Rules rules, int player, Field field) {
        this.rules = rules;
        this.player = player;
        this.field = field;
    }
    /**
     * Перебирает доступные ходы и выбирает наиболее выгодный ход.
     * 
     * @return наиболее предпочтительный ход.
     */
    public Move getBestMove() {
        long time = System.currentTimeMillis();
        Move[] moves = rules.getMoves(player);
        int maxScore = Integer.MIN_VALUE;
        Move bestMove = null;
        LOG.debug("Estimated available moves:");
        for (Move m : moves) {
            field.doMove(m, player);
            int score = score(field, -player, m);
            field.undoMove(m, player);
            if (score > maxScore) {
                bestMove = m;
                maxScore = score;
            }
            LOG.debug("\t" + m + " score " + score);
        }
        time = System.currentTimeMillis() - time;
        LOG.debug("Time " + time + " ms; \tcount " + moves.length);
        return bestMove;
    }

    /**
     * Выполняет оценку сделанного хода.
     * 
     * @param field
     *            игровое поле после выполненного хода.
     * @param player
     *            идентификатор игрока, для которого строится оценка.
     * @param move
     *            описание выполненного хода.
     * @return оценка выполненного хода.
     */
    protected abstract int score(Field field, int player, Move move);


}
