package ru.kostikov.start;

import ru.kostikov.models.*;

/**
 * Created by Алексей on 18.07.2016.
 */
public class StartUI {

    private Input input;
    private Tracker tracker;

    /**
     *
     * @param input
     * @param tracker
     */
    public StartUI(Input input, Tracker tracker){
        this.input  = input;
        this.tracker = tracker;
    }

    /**
     *  Запуск меню и трекера
     */
    public void run(){

        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do{
            menu.show();
            int key = Integer.valueOf(input.ask("Select: "));
            menu.select(key);
        }while(menu.exit() == false);


    }

    public static void main(String[] args) {

        Input input = new ConsoleInput();//new StubInput( new String[]{"Creat stub task"});
        StartUI ui = new StartUI(input, new Tracker());

        ui.run();

    }
}
