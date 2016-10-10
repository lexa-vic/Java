package ru.kostikov;

/**
 * Created by Алексей on 10.10.2016.
 */
public class Role extends Base {
    String id;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
