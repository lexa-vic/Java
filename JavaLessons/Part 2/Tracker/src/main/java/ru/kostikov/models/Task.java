package ru.kostikov.models;

/**
 * Created by Алексей on 14.07.2016.
 */
public class Task extends Item{

    public Task(String name, String description){
        this.name        = name;
        this.description = description;
    }

    public String calculatePrise(){
        return "100%";
    }
}
