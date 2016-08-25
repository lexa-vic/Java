package ru.kostikov.filefinder;

/**
 * Created by Алексей on 24.08.2016.
 * Класс сравнения исходного файла по заданному имени
 */
public class FullNameMatcher implements FindMatcher {

    private String fullName;

    /**
     * Конструктор
     * @param fullName имя файла для сравнения
     */
    public FullNameMatcher(String fullName){
        this.fullName = fullName;
    }

    @Override
    public boolean compare(String str) {
        return this.fullName.equals(str);
    }
    @Override
    public boolean equals(Object obj){
        if(obj == this)
            return true;
        // obj ссылается на null
        if(obj == null)
            return false;
        // Удостоверимся, что ссылки имеют тот же самый тип
        if(!(getClass() == obj.getClass()))
            return false;
        else
        {
            FullNameMatcher tmp = (FullNameMatcher)obj;
            if(tmp.fullName == this.fullName)
                return true;
            else
                return false;
        }
    }
}
