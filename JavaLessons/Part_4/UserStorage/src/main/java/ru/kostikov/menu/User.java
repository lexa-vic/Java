package ru.kostikov.menu;

/**
 * Created by Алексей on 16.09.2016.
 */
public class User {

    private String name;
    private int age;
    private int id;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Name getter
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * Name setter
     * @param name User's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Age getter
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Age setter
     * @param age User's age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Id getter
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Id setter
     * @param id User's id
     */
    public void setId(int id) {
        this.id = id;
    }
}
