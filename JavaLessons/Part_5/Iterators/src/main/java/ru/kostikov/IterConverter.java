package ru.kostikov;

import java.util.Iterator;

/**
 * Created by Алексей on 09.10.2016.
 */
public interface IterConverter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it);
}
