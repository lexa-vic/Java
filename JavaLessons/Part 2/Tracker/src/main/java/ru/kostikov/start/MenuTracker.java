package ru.kostikov.start;

import ru.kostikov.models.Comment;
import ru.kostikov.models.Item;
import ru.kostikov.models.Task;

import java.util.Arrays;

/**
 * Created by Алексей on 21.07.2016.
 */
public class MenuTracker {
    /** Интерфейс входа */
    private Input   input;
    /** Трекер */
    private Tracker tracker;
    /** Хранилище пукнтов меню */
    private UserAction[] actions = new UserAction[4];
    /** Флаг выхода из меню */
    private boolean exit;

    public MenuTracker(Input input, Tracker tracker){
        this.input   = input;
        this.tracker = tracker;
        this.exit    = false;
    }

    /**
     *  Добавление подклассов(пунктов) в меню
     */
    public void fillActions(){
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowItems();
        this.actions[2] = new FindItem();
        this.actions[3] = new ExitMenu();
    }

    /**
     * Создает и возвращает последовательность значений валидных для приема меню
     * @return
     */
    public int[] getMenuRange(){
        int[] range = new int[this.actions.length];
        int count = 0;
        for (count = 0; count < this.actions.length; count++){
            if (this.actions[count] != null){
                range[count] = count+1;
            }else{
                break;
            }
        }
        range = Arrays.copyOf(range, count+1);

        return range;
    }

    /**
     * Выбор пункта меню
     * @param key
     */
    public void select(int key){
        // Смещаем ключ на единицу, т.к. для пользователя отсчет начинается от 1, а в нутри от 0
        key -= 1;
        if(key >= 0 && key < this.actions.length){
            this.actions[key].execute(this.input, this.tracker);
        }

    }

    /**
     *  Отображение меню
     */
    public void show(){
        for(UserAction action: this.actions){
            if (action != null){
                System.out.println(action.info());
            }
        }
    }

    public boolean exit(){
        return this.exit;
    }

    /**
     *  Класс - выход из главного меню
     */
    private class ExitMenu implements UserAction{
        /**
         * @return
         */
        public int key(){
            return 4;
        }

        /**
         * @param input
         * @param tracker
         */
        public void execute(Input input, Tracker tracker){
            exit = true;
        }

        /**
         * @return
         */
        public String info(){
            return String.format("%s. %s",this.key(), "Exit." );
        }
    }

}
/**
 * Пункт меню добавления заявки
 *
 */
class AddItem implements UserAction{
    /**
     * Получение ключа пункта - место в хранилище пунктов меню
     * @return
     */
    public int key(){
        return 1;
    }

    /**
     * Добавление комментария к заявке
     * @param item
     * @param input
     */
    private void addCommentMenu(Item item, Input input){

        String anyMore = null;

        do{
            String comment = input.ask("Please enter a comment: ");
            item.addComment(new Comment(comment));

            anyMore = input.ask("Any more?(y/n): ");
        }while(anyMore.equals("y"));
    }

    /**
     * Выполнение пункта меню
     * @param input
     * @param tracker
     */
    public void execute(Input input, Tracker tracker){
        String name = input.ask("Please enter task's name ");
        String desc = input.ask("Please enter task's description ");

        Item task   = new Task(name, desc);

        String commentCmd = input.ask("Would you like add comment?(y/n) ");

        if(commentCmd.equals("y")) {
            addCommentMenu(task, input);

        }
        tracker.add(task);

    }

    /**
     * Описание - отображение пункта
     * @return
     */
    public String info(){
        return String.format("%s. %s",this.key(), "Add the new item." );
    }
}
/**
 * Пункт меню отображения всех заявок
 *
 */
 class ShowItems implements UserAction{
    /**
     * Получение ключа пункта - место в хранилище пунктов меню
     * @return
     */
    public int key(){
        return 2;
    }

    /**
     * Выполнение пункта меню
     * @param input
     * @param tracker
     */
    public void execute(Input input, Tracker tracker){
        Item[] allItem = tracker.getAll();
        if(allItem.length != 0){
            for (Item item: allItem){
                System.out.printf("Task id: %s name: %s, description: %s \n", item.getId(), item.getName(), item.getDescription());
                for(Comment comment : item.getAllComments()){
                    System.out.println("Comment: " + comment.getComment());
                }
            }
            input.ask("Please enter any key... ");
        }else{
            input.ask("Task list is empty. Please enter any key... ");
        }
    }
    /**
     * Описание - отображение пункта
     * @return
     */
    public String info(){
        return String.format("%s. %s",this.key(), "Show all items." );
    }
}

/**
 * Пункт меню поиска заявки
 *
 */
class FindItem implements UserAction{
    /**
     * Получение ключа пункта - место в хранилище пунктов меню
     * @return
     */
    public int key(){
        return 3;
    }
    /**
     * Выполнение пункта меню
     * @param input
     * @param tracker
     */
    public void execute(Input input, Tracker tracker){

        Integer count = 0;

        String findSubString = input.ask("Please enter task's name or description: ");

        Item[] findItem = tracker.findByFilter(findSubString);
        /** Последовательность допустимых значений ввода при выборе нужной задачи */
        int[]  findCountRange = new int[findItem.length];

        if (findItem.length != 0){
            for (Item item: findItem){
                if (item != null){
                    findCountRange[count] = ++count;
                    System.out.printf("%d. Task id: %s name: %s, description: %s \n",count, item.getId(), item.getName(), item.getDescription());
                    for(Comment comment : item.getAllComments()){
                        System.out.println("Comment: " + comment.getComment());
                    }
                }
            }
            if (count != 0){
                findCountRange = Arrays.copyOf(findCountRange, count);
                count = input.ask("Please choose the task: ",findCountRange );
                EditSubMenu subMenu = new EditSubMenu(findItem[count-1], input, tracker );

                subMenu.run();
            }
        }else{
            input.ask("Task not found...Please enter any key... ");
        }
    }
    /**
     * Описание - отображение пункта
     * @return
     */
    public String info(){
        return String.format("%s. %s",this.key(), "Find item." );
    }

    /**
     *  Подменю после выбора конкретной заявки
     *  Выполняем операции модификации или удаления
     */
    private class EditSubMenu{
        private Item    item;
        private Input   input;
        private Tracker tracker;
        private UserAction[] subActions = new UserAction[5];
        private boolean exit = false;

        public EditSubMenu(Item item, Input input, Tracker tracker ){
            this.item    = item;
            this.input   = input;
            this.tracker = tracker;
            this.exit    = false;
        }
        /**
         *  Добавление подклассов(пунктов) в меню
         */
        private void fillActions(){
            this.subActions[0] = new ChangeName();
            this.subActions[1] = new ChangeDesc();
            this.subActions[2] = new AddComment();
            this.subActions[3] = new DeleteItem();
            this.subActions[4] = new ExitSubMenu();
        }

        /**
         * Создает и возвращает последовательность значений валидных для приема меню
         * @return
         */
        public int[] getMenuRange(){
            int[] range = new int[this.subActions.length];
            int count = 0;
            for (count = 0; count < this.subActions.length; count++){
                if (this.subActions[count] != null){
                    range[count] = count+1;
                }else{
                    break;
                }
            }
            range = Arrays.copyOf(range, count+1);

            return range;
        }

        /**
         * Выбор подпункта
         * @param key
         */
        private void select(int key){
            key -= 1;
            if(key >= 0 && key < this.subActions.length) {
                this.subActions[key].execute(this.input, this.tracker);
            }
        }

        /**
         *  Отображения подпуктнов
         */
        private void show(){
            for(UserAction action: subActions){
                if (action != null){
                    System.out.println(action.info());
                }
            }
        }

        /**
         *  Запуск подменю
         */
        public void run(){
            this.fillActions();
            do{
                this.show();
                //int key = Integer.valueOf(input.ask("Select: ", getMenuRange()));
                this.select(input.ask("Select: ", this.getMenuRange()));
            }while(this.exit == false);
        }

        /**
         *  Класс - пункт подменю изменения имени заявки
         */
        private class ChangeName implements UserAction{
            /**
             * @return
             */
            public int key(){
                return 1;
            }

            /**
             * @param input
             * @param tracker
             */
            public void execute(Input input, Tracker tracker){
                String name = input.ask("Please enter new task's name ");
                item.setName(name);
            }

            /**
             * @return
             */
            public String info(){
                return String.format("%s. %s",this.key(), "Change name." );
            }
        }
        /**
         *  Класс - пункт подменю изменения описания заявки
         */
        private class ChangeDesc implements UserAction{
            public int key(){
                return 2;
            }

            public void execute(Input input, Tracker tracker){
                String desc = input.ask("Please enter new task's description ");
                item.setDescription(desc);
            }

            public String info(){
                return String.format("%s. %s",this.key(), "Change description." );
            }
        }
        /**
         *  Класс - пункт подменю добавления комментария к заявке
         */
        private class AddComment implements UserAction{
            /**
             * @return
             */
            public int key(){
                return 3;
            }

            /**
             * @param input
             * @param tracker
             */
            public void execute(Input input, Tracker tracker){
                String anyMore = null;

                do{
                    String comment = input.ask("Please enter a comment: ");
                    item.addComment(new Comment(comment));

                    anyMore = input.ask("Any more?(y/n): ");
                }while(anyMore.equals("y"));
            }

            /**
             * @return
             */
            public String info(){
                return String.format("%s. %s",this.key(), "Add comment." );
            }
        }
        /**
         *  Класс - пункт подменю удаление заявки
         */
        private class DeleteItem implements UserAction{
            /**
             * @return
             */
            public int key(){
                return 4;
            }

            /**
             * @param input
             * @param tracker
             */
            public void execute(Input input, Tracker tracker){
                tracker.del(item);
                input.ask("Task delete. Please enter any key... ");

                exit = true;
            }

            /**
             * @return
             */
            public String info(){
                return String.format("%s. %s",this.key(), "Delete task." );
            }
        }
        /**
         *  Класс - пункт подменю выход из подменю
         */
        private class ExitSubMenu implements UserAction{
            /**
             * @return
             */
            public int key(){
                return 5;
            }

            /**
             * @param input
             * @param tracker
             */
            public void execute(Input input, Tracker tracker){
                exit = true;
            }

            /**
             * @return
             */
            public String info(){
                return String.format("%s. %s",this.key(), "Exit." );
            }
        }

    }
}


