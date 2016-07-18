package ru.kostikov.start;

import ru.kostikov.models.*;

/**
 * Created by Алексей on 18.07.2016.
 */
public class StartUI {

    public static void main(String[] args) {

        Tracker traker = new Tracker();
        String id = null;

        // Добавление заявки
        traker.add(new Task("First Task", "First Desc"));
        traker.add(new Task("Second Task", "Second Desc"));

        System.out.println("=============== Add Item ================");
        for (Item item: traker.getAll()){
            System.out.printf("Task id: %s name: %s, description: %s \n", item.getId(), item.getName(), item.getDescription());
            id = item.getId();
        }

        System.out.println("=============== Del Item ================");

        traker.del(traker.findById(id));
        // Удалена последня задача
        traker.add(new Task("Next Task", "Next Desc"));
        for (Item item: traker.getAll()){
            System.out.printf("Task id: %s name: %s, description: %s \n", item.getId(), item.getName(), item.getDescription());
            id = item.getId();
        }
        System.out.println("=============== Find item ================");
        // Поиск по имени или описанию
        Item[] findItem = traker.findByFilter("First");

        for (Item item: findItem){
            if (item != null){
                System.out.printf("Task id: %s name: %s, description: %s \n", item.getId(), item.getName(), item.getDescription());
            }
        }

        System.out.println("=============== Change item ================");
        // Изменение описания

        for (Item item: findItem){
            if (item != null){
                item.setDescription("New description");
                System.out.printf("Task id: %s name: %s, description: %s \n", item.getId(), item.getName(), item.getDescription());
            }
        }


        System.out.println("=============== Add comments ================");
        // Изменение описания

        for (Item item: findItem){
            if (item != null){
                item.addComment(new Comment("Comment one"));
                item.addComment(new Comment("Comment two"));
                item.addComment(new Comment("Comment three"));
                System.out.printf("Task id: %s name: %s, description: %s \n", item.getId(), item.getName(), item.getDescription());

                for(Comment comment : item.getAllComments()){
                    System.out.println(comment.getComment());
                }
            }
        }


        //

//        for (Item item: traker.getAll()){
//            System.out.println(item.getName());
//        }
    }
}
