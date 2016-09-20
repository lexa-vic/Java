package ru.kostikov.menu;

import java.util.ArrayList;

/**
 * Created by Алексей on 16.09.2016.
 */
public class UserStorage {
    private ArrayList<User> userStorage = new ArrayList<>();
    private Validator validator;

    public UserStorage(Validator validator) {
        this.validator = validator;
    }

    /**
     * Add User to storage
     * @param user
     */
    public void addUser(User user){
        this.userStorage.add(user);
    }

    /**
     * Deletes User from storage
     * @param user
     */
    public void deleteUser(User user){
        userStorage.remove(user);
    }

    /**
     * Update the user if id equal
     * @param user
     */
    public boolean update(User user){
        boolean result = this.validator.checkParams(user);

        if (result){
            for (User userInStorage: userStorage) {
                if (userInStorage.getId() == user.getId()){
                    userStorage.remove(userInStorage);
                    userStorage.add(user);
                }
            }
        }

        return result;
    }

    /**
     * Gets all users in the stoarge
     * @return
     */
    public ArrayList<User> getUserList(){
        return userStorage;
    }
}
