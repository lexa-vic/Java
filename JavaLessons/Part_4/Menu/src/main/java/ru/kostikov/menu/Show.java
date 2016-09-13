package ru.kostikov.menu;

import java.io.IOException;
import java.io.Writer;

/**
 * Created by Алексей on 13.09.2016.
 */
public interface Show {
    public void showMenu(Writer output, String prefix) throws IOException;
}
