package ru.kostikov.models;

/**
 * Created by Алексей on 18.07.2016.
 */
class Comment {
    /**
     * Комментарий
     */
    private String comment;

    /**
     * Создание комментария
     * @param comment
     */
    Comment(String comment){
        this.comment = comment;
    }

    /**
     * Исправление комментария
     * @param newComment
     */
    void editComment(String newComment){
        this.comment = newComment;
    }

    /**
     * Получение комментария
     * @return
     */
    String getComment(){
        return this.comment;
    }
}
