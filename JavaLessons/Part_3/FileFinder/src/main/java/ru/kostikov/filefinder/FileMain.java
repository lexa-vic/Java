package ru.kostikov.filefinder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;


/**
 * Created by Алексей on 20.08.2016.
 */
public class FileMain extends SimpleFileVisitor<Path> {

    public static void main(String[] args) {
        Ui argsParser = new Ui();

        ParseValue parseValue = argsParser.argsParse(args);
        File out = new File(parseValue.fileOutName);
        FileOutputStream output = null;

        if(out.exists()){
            out.delete();
        }
        try {
            out.createNewFile();
            output = new FileOutputStream(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileFinder fileFinder = new FileFinder(parseValue.matchTemplate, output);
        fileFinder.findFiles(Paths.get(parseValue.url));
    }
}

