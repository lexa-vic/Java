package ru.kostikov.filefinder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Алексей on 24.08.2016.
 * Класс сравнения исходного файла по заданному регулярному выражению
 */
public class RegExpMatcher implements FindMatcher {

    private Pattern regExp;

    /**
     * Конструктор
     * @param regExp скомпилиненное регулярное выражение.
     */
    public RegExpMatcher(Pattern regExp){
        this.regExp = regExp;
    }

    @Override
    public boolean compare(String str) {
        Matcher m = this.regExp.matcher(str);
        return m.matches();
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
            RegExpMatcher tmp = (RegExpMatcher)obj;
            if(tmp.regExp.pattern().equals(this.regExp.pattern()))
                return true;
            else
                return false;
        }
    }
}
