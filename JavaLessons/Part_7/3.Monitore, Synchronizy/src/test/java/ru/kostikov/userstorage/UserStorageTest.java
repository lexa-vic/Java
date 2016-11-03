package ru.kostikov.userstorage;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 03.11.2016.
 */
public class UserStorageTest {

    @Test
    public void whenTransferMonyFromTwoUsersInOneThread(){
        User a = new User("Vasya");
        User b = new User("Kolya");

        a.setAmount(1000);
        UserStorage userStorage = new UserStorage();
        userStorage.add(a);
        userStorage.add(b);

        userStorage.moneyTransfer("Vasya", "Kolya", 1000);

        Assert.assertThat(1000, is(b.getAmount()));
    }

    @Test
    public void whenTransferMonyFromTwoUsersInManyThread(){
        User a = new User("Vasya");
        User b = new User("Kolya");
        User c = new User("Petya");

        a.setAmount(50_000);
        c.setAmount(50_000);
        UserStorage userStorage = new UserStorage();
        userStorage.add(a);
        userStorage.add(b);
        userStorage.add(c);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++){
                    userStorage.moneyTransfer("Vasya", "Kolya", 1000);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++){
                    userStorage.moneyTransfer("Petya", "Vasya", 1000);
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Assert.assertThat(50_000, is(a.getAmount()));
    }
}