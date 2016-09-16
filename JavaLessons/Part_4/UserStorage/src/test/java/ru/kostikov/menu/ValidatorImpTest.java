package ru.kostikov.menu;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 16.09.2016.
 */
public class ValidatorImpTest {
    @Test
    public void whenParamsRightThenReturnTrue() throws Exception {
        boolean result = false;
        boolean expected = true;
        User user = new User("Aleksey", 27);
        user.setId(1);

        ValidatorImp validatorImp = new ValidatorImp();
        result = validatorImp.checkParams(user);

        assertThat(expected, is(result));
    }

    @Test
    public void whenParamsWrongThenReturnFalse() throws Exception {
        boolean result = true;
        boolean expected = false;

        User user = new User("Aleksey", 27);

        ValidatorImp validatorImp = new ValidatorImp();
        result = validatorImp.checkParams(user);

        assertThat(expected, is(result));
    }

}