package ru.kostikov.start;

import ru.kostikov.models.*;

/**
 * Created by Алексей on 18.07.2016.
 */
public class StartUI {
    private Input input;
    private MenuTracker menu;

    /**
     * Constructor.
     * @param input
     * @param menu
     */
    public StartUI(Input input, MenuTracker menu ){
        this.input = input;
        this.menu = menu;
        this.menu.fillActions();
    }

    /**
     *  Start menu
     */
    public void run(){
        do{
            this.menu.show();
            this.menu.select(input.ask("Select: ", menu.getMenuRange()));
        }while(!menu.exit());


    }

    public static void main(String[] args) {

        Input input = new ValidateInput();
        StartUI ui = new StartUI(input,  new MenuTracker(input, new Tracker()));

        ui.run();

    }
}
