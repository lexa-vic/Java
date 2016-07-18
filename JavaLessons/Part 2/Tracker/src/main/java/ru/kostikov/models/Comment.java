package ru.kostikov.models;

/**
 * Created by Алексей on 18.07.2016.
 */
public class Comment {
    /**
     * Комментарий
     */
    private String comment;

    /**
     * Создание комментария
     *
     * @param comment
     */
    public Comment(String comment) {
        this.comment = comment;
    }

    /**
     * Исправление комментария
     *
     * @param newComment
     */
    public void editComment(String newComment) {
        this.comment = newComment;
    }

    /**
     * Получение комментария
     *
     * @return
     */
    public String getComment() {
        return this.comment;
    }
}
