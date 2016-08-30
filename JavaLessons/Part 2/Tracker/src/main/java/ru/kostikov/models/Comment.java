package ru.kostikov.models;

/**
 * The class implements comments for a request.
 * Created by Алексей on 18.07.2016.
 */
public class Comment {
    /** Comment*/
    private String comment;
    /**
     * Constructor.
     * @param comment
     */
    public Comment(String comment) {
        this.comment = comment;
    }

    /**
     * Edit comment.
     * @param newComment
     */
    public void editComment(String newComment) {
        this.comment = newComment;
    }

    /**
     * Get comment.
     * @return
     */
    public String getComment() {
        return this.comment;
    }
}
