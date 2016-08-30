package ru.kostikov.models;

import java.util.Arrays;

/**
 * This class implements common item of tracker.
 * Created by Алексей on 14.07.2016.
 */
public class Item {

    /** Identifier. */
    private   String id;
    /** Request name. */
    protected String name;
    /** Request description. */
    protected String description;
    /** Create date. */
    protected long create_time;
    /** Size of commnts array. */
    private int commentStorageSize = 5;
    /** Current commnts quantity. */
    private int currentCommentSize = 0;
    /** Comments to the request. */
    protected Comment[] comments = new Comment[this.commentStorageSize];

    /**
     *  Default constructor.
     */
    public Item(){
    }

    /**
     * Constructor.
     * @param name Request name.
     * @param description Request description.
     * @param create_time Create date.
     */
    public Item(String name, String description, long create_time){
        this.name = name;
        this.description = description;
        this.create_time = create_time;
    }
    /**
     * Get request name.
     * @return name.
     */
    public String getName(){

        return this.name;
    }
    /**
     * Set request name.
     * @param name name.
     */
    public void setName(String name){

        this.name = name;
    }
    /**
     * Get request description.
     * @return description
     */
    public String getDescription(){

        return this.description;
    }
    /**
     * Set description.
     * @param description
     */
    public void setDescription(String description){

        this.description = description;
    }
    /**
     * Get create date.
     * @return create date.
     */
    public long getCreateTime(){

        return this.create_time;
    }
    /**
     * Set id.
     * @param id
     */
    public void setId(String id){
        this.id = id;
    }

    /**
     * Get id.
     * @return
     */
    public String getId() {
        return this.id;
    }

    /**
     * Add comment.
     * @param comment
     * @return true - if comment has been added successfully.
     */
    public boolean addComment(Comment comment){
        boolean result = false;

        if(comment != null){
            // Если нет места раширяем массив
            if (this.currentCommentSize >= this.comments.length){
                this.commentStorageSize += 20;
                this.comments = Arrays.copyOf(this.comments, this.commentStorageSize);
            }
            this.comments[this.currentCommentSize++] = comment;
            result = true;
        }

        return result;
    }

    /**
     * Read all comments.
     * @return array of comments.
     */
    public Comment[] getAllComments(){
        Comment[] result = new Comment[this.currentCommentSize];

        for(int i = 0; i < this.currentCommentSize; i++)
        {
            result[i] = this.comments[i];
        }

        return result;
    }

}
