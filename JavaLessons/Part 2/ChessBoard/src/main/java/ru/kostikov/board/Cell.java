package ru.kostikov.board;

/**
 * Created by Алексей on 27.07.2016.
 */
public class Cell {
    /** Имя(идентификатор) ячейки*/
    private String name;

    /**
     * Конструктор ячейки поля, создаем с указанием имени(идентификатора) ячейки
     * @param name
     */
    Cell(String name){
        this.name = name;
    }

    /**
     * Вызов имени ячейки
     * @return String name
     */
    public String getName(){
        return this.name;
    }
}
