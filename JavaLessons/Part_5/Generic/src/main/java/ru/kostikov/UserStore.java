package ru.kostikov;

/**
 * Created by Алексей on 10.10.2016.
 */
public class UserStore implements Store<User> {

    private SimpleArray<Base> userStore;

    public UserStore(SimpleArray<Base> userStore) {
        this.userStore = userStore;
    }
}
