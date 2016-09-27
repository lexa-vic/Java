package ru.kostikov.ai;

/**
 * Created by Алексей on 27.09.2016.
 */
public interface GamePattern {

    /**
     * Расчет оценки линии
     * @param line
     * @return
     */
    int getLineScore(String line);
}
