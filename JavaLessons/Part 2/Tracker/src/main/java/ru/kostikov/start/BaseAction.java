package ru.kostikov.start;

/**
 * Created by Алексей on 25.07.2016.
 */
public abstract class BaseAction implements UserAction {
    /** Menu name */
    private String name;

    BaseAction(String name){
        this.name = name;
    }
    /**
     * Menu key - menu number in the common list.
     * @return key.
     */
    abstract public int key();

    /**
     * Do action in th submenu.
     * @param input input interface
     * @param tracker Tracker class
     */
    abstract public void execute(Input input, Tracker tracker);

    /**
     * Print submenu name.
     * @return submenu name.
     */
    public String info(){
        return String.format("%s. %s",this.key(), this.name );
    }
}
