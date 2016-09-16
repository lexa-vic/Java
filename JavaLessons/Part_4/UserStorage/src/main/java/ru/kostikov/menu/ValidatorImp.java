package ru.kostikov.menu;

/**
 * Created by Алексей on 16.09.2016.
 */
public class ValidatorImp implements Validator {
    @Override
    public boolean checkParams(User user) {
        boolean result = false;
        if (user.getId() != 0 && user.getAge() != 0 && user.getName() != null){
            result = true;
        }
        return result;
    }
}
