package ru.kostikov.start;

import ru.kostikov.models.*;

/**
 * Created by Алексей on 14.07.2016.
 */
public class Tracker {

    public Item[] items = new Item[3];

    public static void main(String[] args) {

        Tracker traker = new Tracker();

        traker.items[0] = new Item("item", "desc", 0);
        traker.items[1] = new Task("task", "desc");
        traker.items[2] = new Bug();

        for(Item item: traker.items){

            if(item instanceof Task) {
                System.out.printf("%s\n", ((Task) item).calculatePrise());
            }
            System.out.printf("%s %s %d\n", item.getName(), item.getDescription(), item.getCreateTime());
        }
    }

}
