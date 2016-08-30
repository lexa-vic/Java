package ru.kostikov.start;

import ru.kostikov.models.*;

/**
 * Created by Алексей on 18.07.2016.
 */
public class StartUI {

    private Input input;
    private Tracker tracker;

    /**
     * Constructor.
     * @param input
     * @param tracker
     */
    public StartUI(Input input, Tracker tracker){
        this.input  = input;
        this.tracker = tracker;
    }

    /**
     *  Start menu and tracker.
     */
    public void run(){

        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do{
            menu.show();
            menu.select(input.ask("Select: ", menu.getMenuRange()));
        }while(!menu.exit());


    }

    public static void main(String[] args) {

        Input input = new ValidateInput();
        StartUI ui = new StartUI(input, new Tracker());

        ui.run();

    }
}
