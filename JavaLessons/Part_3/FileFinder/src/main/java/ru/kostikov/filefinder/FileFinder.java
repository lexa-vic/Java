package ru.kostikov.filefinder;

import com.google.common.base.Joiner;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * Created by Алексей on 22.08.2016.
 * Класс поисковик файла по маске, имени или регулярному выражению
 * по заданному адресу
 */
public class FileFinder extends SimpleFileVisitor<Path> {

    /** Мэтчер поиска файлов - услови или маска поиска */
    private FindMatcher matcher;
    /** Выходной поток результата */
    private OutputStream output;

    /**
     * Конструктор класса
     * @param matcher мэтчер поиска файлов
     * @param output выходной поток для результата
     */
    public FileFinder(FindMatcher matcher, OutputStream output){
        this.matcher = matcher;
        this.output  = output;
    }

    /**
     * При нахождении любого файла сраваниет его по матчеру
     * @param file путь к файлу
     */
    private void compare(Path file) {
        if(this.matcher.compare(file.getFileName().toString())){
            try {

                output.write(Joiner.on("").join(file.toAbsolutePath().toString(),"\r\n").getBytes());
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
        this.compare(file);
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file,
                                           IOException exc) {
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
