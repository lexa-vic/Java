package ru.kostikov.tictactoe;

/**
 * Created by Алексей on 29.09.2016.
 */
public class HumanPlayer implements Player{
    PlayerInput input;
    PlayerOutput output;
    String name = "";

    public HumanPlayer(String name, PlayerInput moveInput, PlayerOutput playerOutput) {
        this.name = name;
        this.input = moveInput;
        this.output = playerOutput;
    }

    @Override
    public void init(Field field) {

    }

    @Override
    public Move getMove() {
        return this.input.inputMove(this);
    }

    /**
     * Callback ошибки хода
     */
    @Override
    public void badMove() {
        this.output.outputMove();
    }

    /**
     * Имя игрока
     *
     * @return
     */
    @Override
    public String getName() {
        return this.name;
    }
}
