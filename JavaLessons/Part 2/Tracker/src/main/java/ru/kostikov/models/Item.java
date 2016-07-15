package ru.kostikov.models;

/**
 * Created by Алексей on 14.07.2016.
 */
public class Item {

    public String name;

    public String description;
    public long create_time;

    public Item(){

    }

    public Item(String name, String description, long create_time){
        this.name = name;
        this.description = description;
        this.create_time = create_time;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public long getCreateTime(){
        return this.create_time;
    }
}
