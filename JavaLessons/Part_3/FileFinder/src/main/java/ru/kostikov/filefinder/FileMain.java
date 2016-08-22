package ru.kostikov.filefinder;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Optional;

import static java.nio.file.FileVisitResult.CONTINUE;


/**
 * Created by Алексей on 20.08.2016.
 */
public class FileMain extends SimpleFileVisitor<Path> {

    public static void main(String[] args) {

        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");
        Path path = Paths.get("D:\\java\\Java_new\\JavaLessons\\Part_3");

        FileFinder fileFinder = new FileFinder(Optional.of(matcher), System.out);

        fileFinder.findFiles(path);
    }
}
