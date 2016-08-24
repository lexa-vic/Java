package ru.kostikov.filefinder;

/**
 * Created by Алексей on 24.08.2016.
 */
public class FullNameMatcher implements Matcher {

    String fullName;

    public FullNameMatcher(String fullName){
        this.fullName = fullName;
    }

    @Override
    public boolean compare(String str) {
        return this.fullName.equals(str);
    }
}
