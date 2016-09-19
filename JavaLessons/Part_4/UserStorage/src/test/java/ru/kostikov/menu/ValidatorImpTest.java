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

        boolean expected = true;
        User user = new User("Aleksey", 27);
        user.setId(1);

        ValidatorImp validatorImp = new ValidatorImp();
        boolean result = validatorImp.checkParams(user);

        assertThat(expected, is(result));
    }

    @Test
    public void whenIdWrongThenReturnFalse() throws Exception {
        boolean expected = false;

        User user = new User("Aleksey", 27);

        ValidatorImp validatorImp = new ValidatorImp();
        boolean result = validatorImp.checkParams(user);

        assertThat(expected, is(result));
    }

    @Test
    public void whenNameWrongThenValidatorReturnFalse() throws Exception {
        boolean expected = false;

        User user = new User(null, 27);

        ValidatorImp validatorImp = new ValidatorImp();
        boolean result = validatorImp.checkParams(user);

        assertThat(expected, is(result));
    }

    @Test
    public void whenAgeWrongThenValidatorReturnFalse() throws Exception {
        boolean expected = false;

        User user = new User("Aleksey", 0);

        ValidatorImp validatorImp = new ValidatorImp();
        boolean result = validatorImp.checkParams(user);

        assertThat(expected, is(result));
    }

}