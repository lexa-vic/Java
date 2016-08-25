package ru.kostikov.filefinder;

/**
 * Created by Алексей on 24.08.2016.
 * Интерфейс сравнитеря  - подходит ли найденный файл под заданное условие
 */
public interface FindMatcher {
    public boolean compare(String str);
}
