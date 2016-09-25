package ru.kostikov.tictactoe;

import java.util.ArrayList;
import java.util.List;

/**
 * Производит оценку поля: поиск выигрышной комбинации, проверку на наличие пустых
 * клеток...
 * 
 * @author dok
 * 
 */
public class FieldScanner {

    /** Результат исследования линии клеток */
    public static class Score {
        /** Всего клеток исследовано */
        public int investigated;
        /** Количество "своих" клеток в линии */
        public int count;
        /** Количество "своих" клеток идущих подряд */
        public int inrow;

        public Score() {
        }

        /**
         * @param investigated
         *            Всего клеток исследовано
         * @param count
         *            Количество "своих" клеток в линии
         * @param inrow
         *            Количество "своих" клето идущих подряд
         */
        public Score(int investigated, int count, int inrow) {
            this.investigated = investigated;
            this.count = count;
            this.inrow = inrow;
        }
    }

    public enum Line {
        /** Строка */
        ROW(0, -1),
        /** Столбец */
        COLUMN(-1, 0),
        /** Диагональ \ */
        DIAGONAL_1(-1, -1),
        /** Диагональ / */
        DIAGONAL_2(-1, 1);

        Line(int rowInc, int colInc) {
            this.rowInc = rowInc;
            this.colInc = colInc;
        }

        private int rowInc;
        private int colInc;
    }

    /**
     * Проверяет наличие пустых клеток на поле.
     * 
     * @param field
     * @return
     */
    public static boolean isFullField(int[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    /**
     * Ищет выигрышную комбинацию в строке.
     * 
     * @param field
     *            игровое поле.
     * @param winLength
     *            длина выигрышной комбинации.
     * @param index
     *            номер строки с 0, в которой производится поиск.
     * @return список ячеек, составляющих выигрышную комбинацию.
     */
    public static List<Cell> scanRow(int[][] field, int winLength, int index) {
        return scanLine(field, index, 0, 0, 1, winLength);
    }

    /**
     * Ищет выигрышную комбинацию в диагонали, начинающейся в верхней строке.
     * 
     * @param direct
     *            направление диагонали. true - слева направо (\), false - справа налево
     *            (/).
     * @param field
     *            игровое поле.
     * @param winLength
     *            длина выигрышной комбинации.
     * @param index
     *            номер ячейки в верхней строке с 0, в которой начинается диагональ.
     * @return список ячеек, составляющих выигрышную комбинацию.
     */
    public static List<Cell> scanUpDiagonal(boolean direct, int[][] field, int winLength,
            int index) {
        if (direct) {
            return scanLine(field, 0, index, 1, 1, winLength);
        } else {
            return scanLine(field, 0, index, 1, -1, winLength);
        }
    }

    /**
     * Ищет выигрышную комбинацию в диагонали, начинающейся в нижней строке.
     * 
     * @param direct
     *            направление диагонали. true - слева направо (/), false - справа налево
     *            (\).
     * @param field
     *            игровое поле.
     * @param winLength
     *            длина выигрышной комбинации.
     * @param index
     *            номер ячейки в нижней строке с 0, в которой начинается диагональ.
     * @return список ячеек, составляющих выигрышную комбинацию.
     */
    public static List<Cell> scanDownDiagonal(boolean direct, int[][] field,
            int winLength, int index) {
        if (direct) {
            return scanLine(field, field.length - 1, index, -1, 1, winLength);
        } else {
            return scanLine(field, field.length - 1, index, -1, -1, winLength);
        }
    }

    /**
     * Ищет выигрышную комбинацию в столбце.
     * 
     * @param field
     *            игровое поле.
     * @param winLength
     *            длина выигрышной комбинации.
     * @param index
     *            номер столбца с 0, в которой производится поиск.
     * @return список ячеек, составляющих выигрышную комбинацию.
     */
    public static List<Cell> scanCol(int[][] field, int winLength, int index) {
        return scanLine(field, 0, index, 1, 0, winLength);
    }

    /**
     * Считает количество занятых клеток в линии, в которой находится клетка хода, в
     * дипазоне x2 выйгрышной длины. Клетка хода учитывается. Подсчет ведется до ближайшей
     * клетки противника или границы поля.
     * 
     * @param line
     *            идентификатор исследуемой линии.
     * @param field
     *            игровое поле.
     * @param winLength
     *            длина выигрышной комбинации.
     * @param move
     *            клетка хода.
     * @param player
     *            игрок, сделавший ход.
     */
    public static Score scoreLine(Line line, int[][] field, int winLength, Move move,
            int player) {
        Score res1 = scoreHalfLine(field, winLength, move, player, line.rowInc,
                line.colInc);
        Score res2 = scoreHalfLine(field, winLength, move, player, -line.rowInc,
                -line.colInc);
        /* Количество своих клеток */
        res1.count = res1.count + res2.count - 1;
        /* Полное количество исследованных клеток */
        res1.investigated = res1.investigated + res2.investigated - 1;
        /* Количество своих клеток идущих подряд */
        res1.inrow = res1.inrow + res2.inrow - 1;
        return res1;
    }

    /**
     * Считает количество занятых клеток в линии, в которой находится клетка хода, в
     * дипазоне выйгрышной длины. Клетка хода учитывается в каждом допустимом направлении.
     * <p>
     * <i>Клетка хода <u>не</u> учитывается!</i>
     * 
     * @param field
     *            игровое поле.
     * @param winLength
     *            длина выигрышной комбинации.
     * @param move
     *            клетка хода.
     * @param player
     *            игрок, сделавший ход.
     * @param rowInc
     *            инкремент строк.
     * @param colInc
     *            инкремент столбцов.
     * @return объект, содержащий информацию о том, сколько всего клеток исследовано,
     *         количестве "своих" клеток в исследуемой линии и количество "своих" клеток,
     *         идущих подряд.
     */
    private static Score scoreHalfLine(int[][] field, int winLength, Move move,
            int player, int rowInc, int colInc) {
        int r = move.getRow() + rowInc;
        int c = move.getCol() + colInc;
        Score res = new Score();
        /* Берем в расчет начальную клетку */
        res.count = 1;
        res.inrow = 1;
        res.investigated = 1;
        /* Ключ указывающий на то, что "свои" клетки идут подряд */
        boolean inRow = true;
        /*
         * Пока индексы в пределах поля, не встречена чужая клетка и длинна иследуемого
         * ряда не превышает winLength...
         */
        while ((res.investigated < winLength) && (r >= 0) && (r < field.length)
                && (c >= 0) && (c < field.length)
                && (field[r][c] == player || field[r][c] == 0)) {
            if (field[r][c] == player) {
                res.count++;
                if (inRow)
                    res.inrow++;
            } else {
                inRow = false;
            }
            res.investigated++;
            r += rowInc;
            c += colInc;
        }
        return res;
    }

    /**
     * Ищет в линии выигрышную последовательность заполненных клеток.
     * 
     * @param field
     *            игровое поле.
     * @param r
     *            строка клетки с которой будет производиsться поиск.
     * @param c
     *            столбец клетки с которой будет производиться поиск.
     * @param rInc
     *            инкремент индекса строки.
     * @param cInc
     *            инкремент индекса столбца.
     * @param winLength
     *            длина выигрышной комбинации.
     * 
     * @return список ходов, описывающий выигрышную последовательность клеток.
     */
    private static List<Cell> scanLine(int[][] field, int r, int c, int rInc, int cInc,
            int winLength) {
        int p = field[r][c];
        List<Cell> list = new ArrayList<Cell>();

        while ((r >= 0) && (r < field.length) && (c >= 0) && (c < field[0].length)) {
            /*
             * Если встретилась пустая клетка, сбор выигрышных клеток начинается сначала
             */
            if (field[r][c] == 0) {
                list = new ArrayList<Cell>();
            }
            /*
             * Если текущая клетка занята тем же игроком, что и предыдущая, добавляем ее в
             * список выигрышных
             */
            else if (field[r][c] == p) {
                list.add(new Cell(r, c));
                // XXX из-за этого кода выигрышная последовательность может быть не полной
                if (list.size() >= winLength) {
                    return list;
                }
            }
            /*
             * Иначе запоминаем меку игрока с текущей клетки и начинаем формировать
             * выигрышный список снова.
             */
            else {
                p = field[r][c];
                list = new ArrayList<Cell>();
                list.add(new Cell(r, c));
            }
            r += rInc;
            c += cInc;
        }
        return null;
    }
}
