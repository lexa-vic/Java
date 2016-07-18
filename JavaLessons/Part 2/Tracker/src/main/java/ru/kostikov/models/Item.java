package ru.kostikov.models;

import java.util.Arrays;

/**
 * Created by Алексей on 14.07.2016.
 */
public class Item {

    /**
     *  Иденитификатор заявки
     */
    private   String id;

    /**
     *  Имя заявки
     */
    protected String name;


    /**
     *  Описание завки
     */
    protected String description;

    /**
     *  Дата создания
     */
    protected long create_time;

    /**
     *  Размер хранилища комментариев к заявке
     */
    private final int commentStorageSize = 5;
    /**
     *  Текущее кол-во комментариев
     */
    private int currentCommentSize = 0;

    /**
     *  Комментарии к заявке
     */
    protected Comment[] comments = new Comment[this.commentStorageSize];


    public Item(){

    }

    /**
     * Конструктор заявки
     * @param name
     * @param description
     * @param create_time
     */
    public Item(String name, String description, long create_time){
        this.name = name;
        this.description = description;
        this.create_time = create_time;
    }

    /**
     * Получение имени
     * @return
     */
    public String getName(){

        return this.name;
    }

    /**
     * Запись имени
     * @param name
     */
    public void setName(String name){

        this.name = name;
    }

    /**
     * Получить описание заявки
     * @return
     */
    public String getDescription(){

        return this.description;
    }

    /**
     * Запись описания заявки
     * @param description
     */
    public void setDescription(String description){

        this.description = description;
    }

    /**
     * Получение даты создания
     * @return
     */
    public long getCreateTime(){

        return this.create_time;
    }

    /**
     * Установка id
     * @param id
     */
    public void setId(String id){
        this.id = id;
    }

    /**
     * Чтение id
     * @return
     */
    public String getId() {
        return this.id;
    }

    /**
     * Добавить комментарий
     * @param comment
     * @return
     */
    public boolean addComment(Comment comment){
        boolean result = false;

        if(comment != null && currentCommentSize < comments.length){
            this.comments[currentCommentSize++] = comment;
            result = true;
        }
        return result;
    }

    /**
     * Чтение всех комментариев
     * @return
     */
    public Comment[] getAllComments(){
        Comment[] result = new Comment[currentCommentSize];

        for(int i = 0; i < currentCommentSize; i++)
        {
            result[i] = this.comments[i];
        }

        return result;
    }

}
