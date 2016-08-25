package ru.kostikov.filefinder;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 23.08.2016.
 */
public class FileFinderTest {
    @Test
    public void findFilesByMask() throws Exception {
        ClassLoader loader = FileFinderTest.class.getClassLoader();
        String exepect = loader.getResource("ru/kostikov/filefinder/FileFinder.class").getPath();
        String result = null;

        exepect = exepect.substring(1, exepect.length()).replace('/', '\\');

        Path startPath = Paths.get("").toAbsolutePath();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Создаем класс, начинаем искать
        FileFinder fileFinder = new FileFinder(new GlobMacther("*Finder.class"), baos);
        fileFinder.findFiles(startPath);

        Scanner scan = new Scanner(baos.toString());
        while(scan.hasNextLine()){
            if (exepect.equals(scan.nextLine()) ){
                result = exepect;
                break;
            }
        }

        assertThat(exepect,  is(result));
    }

    @Test
    public void findFilesByName() throws Exception {
        ClassLoader loader = FileFinderTest.class.getClassLoader();
        String exepect = loader.getResource("ru/kostikov/filefinder/FileFinder.class").getPath();
        String result = null;

        exepect = exepect.substring(1, exepect.length()).replace('/', '\\');

        Path startPath = Paths.get("").toAbsolutePath();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Создаем класс, начинаем искать
        FileFinder fileFinder = new FileFinder(new FullNameMatcher("FileFinder.class"), baos);
        fileFinder.findFiles(startPath);

        Scanner scan = new Scanner(baos.toString());
        while(scan.hasNextLine()){
            if (exepect.equals(scan.nextLine()) ){
                result = exepect;
                break;
            }
        }

        assertThat(exepect,  is(result));
    }

    @Test
    public void findFilesByRegExp() throws Exception {
        ClassLoader loader = FileFinderTest.class.getClassLoader();
        String exepect = loader.getResource("ru/kostikov/filefinder/FileFinder.class").getPath();
        String result = null;

        exepect = exepect.substring(1, exepect.length()).replace('/', '\\');

        Path startPath = Paths.get("").toAbsolutePath();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("regex:.+\\.(class)");

        // Создаем класс, начинаем искать
        FileFinder fileFinder = new FileFinder(new RegExpMatcher(Pattern.compile("FileFinder.class")), baos);
        fileFinder.findFiles(startPath);

        Scanner scan = new Scanner(baos.toString());
        while(scan.hasNextLine()){
            if (exepect.equals(scan.nextLine()) ){
                result = exepect;
                break;
            }
        }

        assertThat(exepect,  is(result));
    }

}