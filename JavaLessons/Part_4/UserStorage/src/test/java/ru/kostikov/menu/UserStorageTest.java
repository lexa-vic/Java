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
    public void whenUpdateAgeUserThenUpdatesInStorage() throws Exception {
        int expectedAge = 28;
        int resultAge = 1;
        UserStorage userStorage = new UserStorage(new ValidatorImp());
        User user = new User("Aleksey", 27);
        User newUser = new User("Aleksey", 28);
        newUser.setId(1);
        user.setId(1);

        userStorage.addUser(user);
        userStorage.update(newUser);
        resultAge = userStorage.getUserList().get(0).getAge();

        assertThat(expectedAge, is(resultAge));
    }

    @Test
    public void whenUpdateNameUserThenUpdatesInStorage() throws Exception {
        String expectedName= "Ivan";
        UserStorage userStorage = new UserStorage(new ValidatorImp());
        User user = new User("Aleksey", 27);
        User newUser = new User("Ivan", 27);
        newUser.setId(1);
        user.setId(1);

        userStorage.addUser(user);
        userStorage.update(newUser);
        String resultAge = userStorage.getUserList().get(0).getName();

        assertThat(expectedName, is(resultAge));
    }

    @Test
    public void whenUpdateWrongAgeThenNoUpdatesInStorage() throws Exception {
        int expectedAge = 27;
        int resultAge = 1;
        UserStorage userStorage = new UserStorage(new ValidatorImp());
        User user = new User("Aleksey", 27);
        User newUser = new User("Aleksey", 0);
        newUser.setId(1);
        user.setId(1);

        userStorage.addUser(user);

        userStorage.update(newUser);
        resultAge = userStorage.getUserList().get(0).getAge();

        assertThat(resultAge, is(expectedAge));
    }

    @Test
    public void whenUpdateWrongNameThenNoUpdatesInStorage() throws Exception {
        String expectedName = "Aleksey";
        UserStorage userStorage = new UserStorage(new ValidatorImp());
        User user = new User("Aleksey", 27);
        User newUser = new User("Ivan", 0);
        newUser.setId(1);
        user.setId(1);

        userStorage.addUser(user);

        newUser.setName(null);
        userStorage.update(newUser);
        String resultName = userStorage.getUserList().get(0).getName();

        assertThat(resultName, is(expectedName));
    }

}