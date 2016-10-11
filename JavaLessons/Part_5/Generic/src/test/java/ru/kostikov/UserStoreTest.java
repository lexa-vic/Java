package ru.kostikov;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 11.10.2016.
 */
public class UserStoreTest {
    @Test
    public void whenAddNewItemThenItItemGets(){
        User user = new User();
        UserStore userStore = new UserStore(2);

        user.setId("1");

        userStore.add(user);
        Base result = userStore.get("1");

        Assert.assertThat(result, is(user));
    }

    @Test
    public void whenDeletesItemThenItNotFoundInStore(){
        User user = new User();
        UserStore userStore = new UserStore(2);

        user.setId("1");

        userStore.add(user);
        userStore.delete("1");
        Base result = userStore.get("1");
        Base expected = null;

        Assert.assertThat(result, is(expected));
    }

}