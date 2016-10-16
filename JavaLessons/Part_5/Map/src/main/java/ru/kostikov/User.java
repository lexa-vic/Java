package ru.kostikov;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Алексей on 16.10.2016.
 */
public class User {
    public String name;
    public int children;
    public Calendar birthday;

    public User(){}

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User first = new User("Aleksey", 0, new GregorianCalendar(1989,
                Calendar.MARCH, 06));
        User second = new User("Aleksey", 0, new GregorianCalendar(1989,
                Calendar.MARCH, 06));

        Map<User, Object> userMap = new HashMap<>();

        userMap.put(first, new Object());
        userMap.put(second, new Object());

        System.out.println(userMap);
    }


    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
