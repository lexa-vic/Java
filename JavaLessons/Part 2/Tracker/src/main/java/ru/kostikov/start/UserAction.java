package ru.kostikov.start;

/**
 * Created by Алексей on 21.07.2016.
 * Класс пользовательского события - подменю
 */
public interface UserAction {

    /**
     * Ключ меню - номер меню в общем списке
     * @return
     */
    int key();

    /**
     * Выполнение действий подменю
     * @param input
     * @param tracker
     */
    void execute(Input input, Tracker tracker);

    /**
     * Отображение имени подменю
     * @return
     */
    String info();

}
