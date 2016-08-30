package ru.kostikov.start;

/**
 * Created by Алексей on 21.07.2016.
 * Класс пользовательского события - подменю
 */
public interface UserAction {

    /**
     * Get key - index in menu array.
     * @return
     */
    int key();

    /**
     * Execute menu item.
     * @param input
     * @param tracker
     */
    void execute(Input input, Tracker tracker);

    /**
     * Get submenu name.
     * @return
     */
    String info();

}
