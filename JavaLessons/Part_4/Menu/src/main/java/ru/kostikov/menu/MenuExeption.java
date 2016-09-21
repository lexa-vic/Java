package ru.kostikov.menu;

/**
 * Created by Алексей on 21.09.2016.
 */
public class MenuExeption extends Exception {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public MenuExeption(String message) {
        super(message);
    }
}
