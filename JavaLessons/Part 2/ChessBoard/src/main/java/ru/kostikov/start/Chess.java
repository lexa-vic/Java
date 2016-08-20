package ru.kostikov.start;

import ru.kostikov.board.Board;

import java.util.Arrays;
import java.util.Optional;

import ru.kostikov.board.Cell;
import ru.kostikov.figures.*;
import ru.kostikov.players.*;

/**
 * Created by Алексей on 31.07.2016.
 */
public class Chess {

    public static void main(String[] args) {

        boolean moveResult = false;
        Board board   = new Board();
        Player player = new White();

        Optional<Cell> fcellFom = board.getCell("a1");
        Optional<Cell> cellTo = board.getCell("a5");
        if (fcellFom.isPresent() && cellTo.isPresent()){
            moveResult = board.move(fcellFom.get(), cellTo.get());
        }
    }

}
