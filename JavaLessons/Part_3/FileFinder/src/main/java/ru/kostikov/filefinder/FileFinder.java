package ru.kostikov.filefinder;

import com.google.common.base.Joiner;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Optional;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * Created by Алексей on 22.08.2016.
 */
public class FileFinder extends SimpleFileVisitor<Path> {

    /** Мэтчер поиска файлов - услови или маска поиска */
    private Optional<PathMatcher> matcher;

    /** Выходной поток результата */
    private OutputStream output;

    /**
     * Конструктор класса
     * @param matcher - мэтчер поиска файлов
     * @param output  - выходной поток для результата
     */
    public FileFinder(Optional<PathMatcher> matcher, OutputStream output){
        this.matcher = matcher;
        this.output  = output;
    }

    /**
     * При нахождении любого файла сраваниет его по матчеру
     * @param file
     */
    private void search(Path file) {
        final boolean[] res = {false};
        Optional<Path> name = Optional.of(file);

        name.ifPresent( n ->  res[0] = matcher.get().matches(name.get().getFileName()));
        if(res[0]){
            try {

                output.write(Joiner.on("").join(name.get().toString(),"\r\n").getBytes());
                output.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Коллбэк вызываемый при вхождении в файл
     * @param file путь к файлу
     * @param attrs атрибуты
     * @return результат (продолжить, пропустить, остановить)
     */
    @Override
     public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attrs) {
        search(file);
        return CONTINUE;
    }


    /**
     * Запуск поиска всех подходящих файлов
     * @param startDict - стартовый путь поиска
     */
    public void findFiles(Path startDict){
        try {
            Files.walkFileTree(startDict, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
