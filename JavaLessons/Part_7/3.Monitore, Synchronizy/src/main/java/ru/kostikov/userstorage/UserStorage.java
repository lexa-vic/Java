package ru.kostikov.userstorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Алексей on 03.11.2016.
 */
public class UserStorage {

    Map<String, User> storage = new HashMap<>();

    /**
     * Puts User to storage
     * @param user
     */
    public synchronized void add(User user){
        storage.put(user.getName(), user);
    }

    /**
     * Deletes User from storage
     * @param name
     */
    public synchronized void delete(String name){
        storage.remove(name);
    }

    /**
     * Gets User from Storage
     * @param name User's name
     * @return User or null if no users whis this value
     */
    public synchronized User getUser(String name){
        return storage.get(name);
    }

    public synchronized boolean moneyTransfer(String fromUser, String toUser, int amount){
        boolean result = false;
        User userEmitter = storage.get(fromUser);
        User userReceiver = storage.get(toUser);

        if (userEmitter != null && userReceiver != null){
            int existAmount = userEmitter.getAmount();

            if (existAmount - amount >= 0){
                userEmitter.setAmount(existAmount-amount);
                userReceiver.setAmount(userReceiver.getAmount()+amount);
                result = true;
            }
        }
        return result;
    }
}
