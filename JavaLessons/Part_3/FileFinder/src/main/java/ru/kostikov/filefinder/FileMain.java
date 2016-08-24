package ru.kostikov.filefinder;

import java.nio.file.*;


/**
 * Created by Алексей on 20.08.2016.
 */
public class FileMain extends SimpleFileVisitor<Path> {

    public static void main(String[] args) {
        Ui argsParser = new Ui();

        argsParser.argsParse(args);
    }
}

