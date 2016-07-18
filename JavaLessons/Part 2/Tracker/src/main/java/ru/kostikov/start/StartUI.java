package ru.kostikov.start;

import ru.kostikov.models.*;

/**
 * Created by Алексей on 18.07.2016.
 */
public class StartUI {

    public static void main(String[] args) {

        Tracker traker = new Tracker();
        traker.add(new Task("First Task", "First Desc"));
//        traker.add(new Task("First Task", "First Desc"));
        Item[] findItem = traker.findByFilter("First");

        for (Item item: findItem){
            if (item != null){

                System.out.println(item.getName());
            }

        }

//        for (Item item: traker.getAll()){
//            System.out.println(item.getName());
//        }
    }
}
