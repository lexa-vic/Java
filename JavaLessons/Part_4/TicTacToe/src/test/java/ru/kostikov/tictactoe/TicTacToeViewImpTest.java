package ru.kostikov.tictactoe;

import com.google.common.base.Joiner;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by user on 30.09.2016.
 */
public class TicTacToeViewImpTest {
    @Test
    public void whenEnterCoorectSizeThenPrintsOnlyOneStr() throws Exception {
        String inputStr = "5";
        InputStream input = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        TicTacToeViewImp view = new TicTacToeViewImp(input, baos);
        int size = view.enterFieldSize();

        String outStr = baos.toString();
        String expected = "Введите размер поля (больше 2): \r\n";

        Assert.assertThat(expected ,is(outStr));
        Assert.assertThat(Integer.valueOf(inputStr) ,is(size));

    }

    @Test
    public void whenEnterSize1ThenPrintsReenterSize() throws Exception {
        String inputStr = "1\n5\n";
        InputStream input = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        TicTacToeViewImp view = new TicTacToeViewImp(input, baos);
        view.enterFieldSize();

        String outStr = baos.toString();
        String expected = Joiner.on("").join("Введите размер поля (больше 2): \r\n", "Введите размер поля (больше 2): \r\n");

        Assert.assertThat(expected ,is(outStr));

    }

    @Test
    public void whenEnterIncorrectSizeThenPrintsWarning() throws Exception {
        String inputStr = "q\n5\n";
        InputStream input = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        TicTacToeViewImp view = new TicTacToeViewImp(input, baos);
        view.enterFieldSize();

        String outStr = baos.toString();
        String expected = Joiner.on("").join("Введите размер поля (больше 2): \r\n","Введите число\r\n", "Введите размер поля (больше 2): \r\n");

        Assert.assertThat(expected ,is(outStr));

    }

    @Test
    public void whenEnterCoorectWinLengthThenPrintsOnlyOneStr() throws Exception {
        String inputStr = "5";
        InputStream input = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        TicTacToeViewImp view = new TicTacToeViewImp(input, baos);
        int size = view.enterWinLength();

        String outStr = baos.toString();
        String expected = "Введите размер выйгрышной комбинации (больше 2): \r\n";

        Assert.assertThat(expected ,is(outStr));
        Assert.assertThat(Integer.valueOf(inputStr) ,is(size));

    }

    @Test
    public void whenEnterWinLength1ThenPrintsReenterWinLength() throws Exception {
        String inputStr = "1\n5\n";
        InputStream input = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        TicTacToeViewImp view = new TicTacToeViewImp(input, baos);
        view.enterWinLength();

        String outStr = baos.toString();
        String expected = Joiner.on("").join("Введите размер выйгрышной комбинации (больше 2): \r\n", "Введите размер выйгрышной комбинации (больше 2): \r\n");

        Assert.assertThat(expected ,is(outStr));

    }

    @Test
    public void whenEnterIncorrectWinLengthThenPrintsWarning() throws Exception {
        String inputStr = "q\n5\n";
        InputStream input = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        TicTacToeViewImp view = new TicTacToeViewImp(input, baos);
        view.enterWinLength();

        String outStr = baos.toString();
        String expected = Joiner.on("").join("Введите размер выйгрышной комбинации (больше 2): \r\n","Введите число\r\n", "Введите размер выйгрышной комбинации (больше 2): \r\n");

        Assert.assertThat(expected ,is(outStr));

    }

    @Test
    public void whenEnterCoorectPlayerXThenPrintsOnlyOneStr() throws Exception {
        String inputStr = "x\n";
        InputStream input = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        TicTacToeViewImp view = new TicTacToeViewImp(input, baos);
        view.choosePlayer();

        String outStr = baos.toString();
        String expected = "Введите за кого хотите играть (x/o)): \r\n";

        Assert.assertThat(expected ,is(outStr));
    }

    @Test
    public void whenEnterCoorectPlayerOThenPrintsOnlyOneStr() throws Exception {
        String inputStr = "o\n";
        InputStream input = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        TicTacToeViewImp view = new TicTacToeViewImp(input, baos);
        view.choosePlayer();

        String outStr = baos.toString();
        String expected = "Введите за кого хотите играть (x/o)): \r\n";

        Assert.assertThat(expected ,is(outStr));
    }

    @Test
    public void whenEnterIncorrectPlayerThenPrintsWarning() throws Exception {
        String inputStr = "q\no\n";
        InputStream input = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        TicTacToeViewImp view = new TicTacToeViewImp(input, baos);
        view.choosePlayer();

        String outStr = baos.toString();
        String expected =  Joiner.on("").join("Введите за кого хотите играть (x/o)): \r\n", "Введите либо X, либо O\r\n", "Введите за кого хотите играть (x/o)): \r\n");

        Assert.assertThat(expected ,is(outStr));
    }

    @Test
    public void whenPlayeAgainYThenReturnTrue() throws Exception {
        String inputStr = "y\n";
        InputStream input = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        TicTacToeViewImp view = new TicTacToeViewImp(input, baos);
        boolean play = view.playAgain();

        String outStr = baos.toString();
        String expected = "Играть еще раз (y/n)): \r\n";

        Assert.assertThat(expected ,is(outStr));
        Assert.assertThat(true ,is(play));
    }

    @Test
    public void whenPlayeAgainNThenReturnTrue() throws Exception {
        String inputStr = "n\n";
        InputStream input = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        TicTacToeViewImp view = new TicTacToeViewImp(input, baos);
        boolean play = view.playAgain();

        String outStr = baos.toString();
        String expected = "Играть еще раз (y/n)): \r\n";

        Assert.assertThat(expected ,is(outStr));
        Assert.assertThat(false ,is(play));
    }

    @Test
    public void whenPlayeAgainIncorrectThenReAsk() throws Exception {
        String inputStr = "q\nn\n";
        InputStream input = new ByteArrayInputStream(inputStr.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        TicTacToeViewImp view = new TicTacToeViewImp(input, baos);
        boolean play = view.playAgain();

        String outStr = baos.toString();
        String expected = Joiner.on("").join("Играть еще раз (y/n)): \r\n", "Введите либо Y, либо N\r\n", "Играть еще раз (y/n)): \r\n");

        Assert.assertThat(expected ,is(outStr));
        Assert.assertThat(false ,is(play));
    }

}