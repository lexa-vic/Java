package ru.kostikov.menu;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 16.09.2016.
 */
public class UserStorageTest {
    @Test
    public void whenAddItemThenGetsListWithItItem() throws Exception {
        User expectedUser = null;
        UserStorage userStorage = new UserStorage(new ValidatorImp());
        User user = new User("Aleksey", 27);
        user.setId(1);

        userStorage.addUser(user);
        expectedUser = userStorage.getUserList().get(0);

        assertThat(expectedUser, is(user));
    }
    @Test
    public void whenAddAndDeleteUserThenGetEptyStorage() throws Exception {
        int expectedSize = 0;
        int resultSize = 1;
        UserStorage userStorage = new UserStorage(new ValidatorImp());
        User user = new User("Aleksey", 27);
        user.setId(1);

        userStorage.addUser(user);
        userStorage.deleteUser(user);
        resultSize = userStorage.getUserList().size();

        assertThat(expectedSize, is(resultSize));
    }

    @Test
    public void whenUpdateUserThenItUpdatesInStorage() throws Exception {
        int expectedAge = 28;
        int resultAge = 1;
        UserStorage userStorage = new UserStorage(new ValidatorImp());
        User user = new User("Aleksey", 27);
        user.setId(1);
        user.setAge(28);

        userStorage.addUser(user);
        resultAge = userStorage.getUserList().get(0).getAge();

        assertThat(expectedAge, is(resultAge));
    }

}