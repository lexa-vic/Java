package ru.kostikov.board;

import ru.kostikov.figures.Figure;

import java.lang.reflect.Field;

/**
 * Created by Алексей on 27.07.2016.
 */
public class Cell {
    /** Имя(идентификатор) ячейки*/
    private String name;

    /** Фигура расположенная в этой ячейке */
    private Figure figure = null;

    private int x;
    private int y;

    /**
     * Конструктор ячейки поля, создаем с указанием имени(идентификатора) ячейки
     * @param name
     */
    Cell(String name, int x, int y){
        this.name = name;
        this.x    = x;
        this.y    = y;
    }

    /**
     * Вызов имени ячейки
     * @return String name
     */
    public String getName(){
        return this.name;
    }


    /**
     * Установка фигуры в ячейку
     * @param figure
     * @return
     */
    public boolean setFigure(Figure figure){
        boolean result = false;

        if (this.figure == null && figure != null){
            this.figure = figure;
            this.figure.setCell(this);

            result = true;
        }

        return result;
    }

    /**
     *  Удаляет фигуру с поля
     */
    public void clearCell(){
        this.figure = null;
//        this.figure.setCell(null);
    }

    public Figure getFigure(){
        return this.figure;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
