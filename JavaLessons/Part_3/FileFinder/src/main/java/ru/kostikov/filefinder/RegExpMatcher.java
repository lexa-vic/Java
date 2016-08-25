package ru.kostikov.filefinder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Алексей on 24.08.2016.
 */
public class RegExpMatcher implements FindMatcher {

    private Pattern regExp;

    public RegExpMatcher(Pattern regExp){
        this.regExp = regExp;
    }

    @Override
    public boolean compare(String str) {
        Matcher m = this.regExp.matcher(str);
        return m.matches();
    }
}
