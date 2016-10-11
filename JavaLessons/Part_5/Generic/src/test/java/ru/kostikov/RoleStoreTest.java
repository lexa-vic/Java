package ru.kostikov;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 11.10.2016.
 */
public class RoleStoreTest {

    @Test
    public void whenAddNewItemThenItItemGets(){
        Role role = new Role();
        RoleStore roleStore = new RoleStore(2);

        role.setId("1");

        roleStore.add(role);
        Base result = roleStore.get("1");

        Assert.assertThat(result, is(role));
    }

    @Test
    public void whenDeletesItemThenItNotFoundInStore(){
        Role role = new Role();
        RoleStore roleStore = new RoleStore(2);

        role.setId("1");

        roleStore.add(role);
        roleStore.delete("1");
        Base result = roleStore.get("1");
        Base expected = null;

        Assert.assertThat(result, is(expected));
    }

}