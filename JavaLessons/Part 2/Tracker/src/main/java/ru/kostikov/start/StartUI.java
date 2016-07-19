package ru.kostikov.start;

import ru.kostikov.models.*;

/**
 * Created by Алексей on 18.07.2016.
 */
public class StartUI {

    private Input input;
    private Tracker traker;

    /**
     *
     * @param input
     * @param traker
     */
    public StartUI(Input input, Tracker traker){
        this.input  = input;
        this.traker = traker;
    }

    /**
     *  Главное меню трекера
     */
    private void showMainMenu(){
        String[] mainMenu = new String[]{
            "1. Add task.",
            "2. Show all tasks.",
            "3. Find task.",
            "4. Exit."
        };

        for (String s: mainMenu){
            System.out.println(s);
        }
    }

    /**
     *  Меню добалвения заявки
     */
    private void addMenu(){
        String name = this.input.ask("Please enter task's name ");
        String desc = this.input.ask("Please enter task's description ");

        Item task   = new Task(name, desc);

        String commentCmd = this.input.ask("Would you like add comment?(y/n) ");

        if(commentCmd.equals("y")) {
            addCommentMenu(task);

        }
        traker.add(task);
    }

    /**
     * Добавления комментариев к заявке
     * @param item
     */
    private void addCommentMenu(Item item){

        String anyMore = null;

        do{
            String comment = this.input.ask("Please enter a comment: ");
            item.addComment(new Comment(comment));

            anyMore = this.input.ask("Any more?(y/n): ");
        }while(anyMore.equals("y"));
    }

    /**
     *  Меню отображения всех заявок
     */
    private void showAllMenu(){

        Item[] allItem = this.traker.getAll();
        if(allItem.length != 0){
            for (Item item: allItem){
                System.out.printf("Task id: %s name: %s, description: %s \n", item.getId(), item.getName(), item.getDescription());
                for(Comment comment : item.getAllComments()){
                    System.out.println("Comment: " + comment.getComment());
                }
            }
            this.input.ask("Please enter any key... ");
        }else{
            this.input.ask("Task list is empty. Please enter any key... ");
        }



    }

    /**
     *  Меню поиска заявок по фильтру
     */
    private void findTaskMenu(){

        Integer count = 0;

        String findSubString = this.input.ask("Please enter task's name or description: ");

        Item[] findItem = traker.findByFilter(findSubString);

        if (findItem.length != 0){
            for (Item item: findItem){
                if (item != null){
                    count++;
                    System.out.printf(count + ". Task id: %s name: %s, description: %s \n", item.getId(), item.getName(), item.getDescription());
                }
            }
            if (count != 0){
                count = Integer.valueOf(this.input.ask("Please choose the task: ")) ;

                editTaskMenu(findItem[count-1]);
            }
        }else{
            this.input.ask("Task not found...Please enter any key... ");
        }


    }

    /**
     * Меню редактирования заявок
     * @param item
     */
    private void editTaskMenu(Item item){

        String[] editTaskMenu = new String[]{
                "1. Change name.",
                "2. Change description.",
                "3. Add comment.",
                "4. Del task.",
                "5. Exit.",
        };


        String cmd;

        do{
            for (String s: editTaskMenu){
                System.out.println(s);
            }
            cmd = this.input.ask("Please enter the command ");

            switch (cmd)
            {
                case "1":
                {
                    String name = this.input.ask("Please enter new task's name ");

                    item.setName(name);

                }
                break;
                case "2":
                {
                    String desc = this.input.ask("Please enter new task's description ");

                    item.setDescription(desc);
                }
                break;
                case "3":
                {
                    addCommentMenu(item);
                }
                break;
                case "4":
                {
                    this.traker.del(item);
                    cmd = "5";
                    this.input.ask("Task delete. Please enter any key... ");
                }
                break;
                default:
                    break;
            }

        }while (!cmd.equals("5"));
    }


    /**
     * Разбор команд главного меню
     * @param cmd
     */
    private void cmdParser(String cmd){

        switch (cmd)
        {
            case "1":
                {
                    this.addMenu();
                }
                break;
            case "2":
                {
                    this.showAllMenu();
                }
                break;
            case "3":
                {
                    this.findTaskMenu();
                }
                break;
            default:
                break;
        }
    }


    /**
     *  Запуск меню и трекера
     */
    public void run(){

        String cmd = "4";
        do{
            this.showMainMenu();
            cmd = this.input.ask("Please enter the command ");

            this.cmdParser(cmd);

        }while(!cmd.equals("4"));

    }

    public static void main(String[] args) {

        Input input = new ConsoleInput();//new StubInput( new String[]{"Creat stub task"});
        StartUI ui = new StartUI(input, new Tracker());

        ui.run();

    }
}
