package ru.kostikov.start;

/**
 * Created by Алексей on 25.07.2016.
 */
public abstract class BaseAction implements UserAction {
    /** Имя меню */
    private String name;

    BaseAction(String name){
        this.name = name;
    }
    /**
     * Ключ меню - номер меню в общем списке
     * @return
     */
    abstract public int key();

    /**
     * Выполнение действий подменю
     * @param input
     * @param tracker
     */
    abstract public void execute(Input input, Tracker tracker);

    /**
     * Отображение имени подменю
     * @return
     */
    public String info(){
        return String.format("%s. %s",this.key(), this.name );
    }
}
