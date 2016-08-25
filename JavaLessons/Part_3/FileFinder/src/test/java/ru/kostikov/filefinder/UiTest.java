package ru.kostikov.filefinder;

import org.junit.Test;

import java.util.Optional;
import java.util.regex.Pattern;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 25.08.2016.
 */
public class UiTest {
    @Test
    public void argsParseFullName() throws Exception {
        Ui argsParser = new Ui();
        String[] args = new String[]{"-d", "D:\\", "-n", "tmp.txt", "-f", "-o", "out.txt"};
        ParseValue expectedValue = new ParseValue();

        expectedValue.url = "D:\\";
        expectedValue.fileOutName = "out.txt";
        expectedValue.matchTemplate = new FullNameMatcher("tmp.txt");

        Optional<ParseValue> parseValue = argsParser.argsParse(args);

        assertThat(expectedValue,  is(parseValue.get()));
    }

    @Test
    public void argsParseGlob() throws Exception {
        Ui argsParser = new Ui();
        String[] args = new String[]{"-d", "D:\\", "-n", "*.txt", "-m", "-o", "out.txt"};
        ParseValue expectedValue = new ParseValue();

        expectedValue.url = "D:\\";
        expectedValue.fileOutName = "out.txt";
        expectedValue.matchTemplate = new GlobMacther("*.txt");

        Optional<ParseValue> parseValue = argsParser.argsParse(args);

        assertThat(expectedValue,  is(parseValue.get()));
    }

    @Test
    public void argsParseRegExp() throws Exception {
        Ui argsParser = new Ui();
        String[] args = new String[]{"-d", "D:\\", "-n", "FileFinder.class", "-r", "-o", "out.txt"};
        ParseValue expectedValue = new ParseValue();

        expectedValue.url = "D:\\";
        expectedValue.fileOutName = "out.txt";
        expectedValue.matchTemplate = new RegExpMatcher(Pattern.compile("FileFinder.class"));

        Optional<ParseValue> parseValue = argsParser.argsParse(args);

        assertThat(expectedValue,  is(parseValue.get()));
    }

}