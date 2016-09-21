package ru.kostikov.menu;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Алексей on 19.09.2016.
 */
public class SimpleGeneratorTest {
    @Test
    public void whenPatternHaveTwoParamsAndTwoParamsSetsThenTwoParamsSubstitution() throws Exception {
        String pattern =  "I am a ${name}, Who are ${subject}? ";
        String expected =  "I am a Aleksey, Who are you? ";
        Map<String, String> params = new HashMap<>();
        params.put("name", "Aleksey");
        params.put("subject", "you");

        SimpleGenerator generator = new SimpleGenerator();

        String result = generator.generate(Optional.of(pattern), Optional.of(params));

        Assert.assertThat(result, is(expected));
    }

    @Test(expected = GeneratorExeption.class)
    public void whenPatternHaveTwoParamsAndThreeParamsSetsThenGeneratesException() throws Exception {
        String pattern =  "I am a ${name}, Who are ${subject}? ";
        Map<String, String> params = new HashMap<>();
        params.put("name", "Aleksey");
        params.put("subject", "you");
        params.put("any", "blabla");

        SimpleGenerator generator = new SimpleGenerator();

        generator.generate(Optional.of(pattern),Optional.of(params));
    }

    @Test(expected = GeneratorExeption.class)
    public void whenPatternHaveTwoParamsAndOneParamSetsThenGeneratesException() throws Exception {
        String pattern =  "I am a ${name}, Who are ${subject}? ";
        Map<String, String> params = new HashMap<>();
        params.put("name", "Aleksey");

        SimpleGenerator generator = new SimpleGenerator();

        generator.generate(Optional.of(pattern), Optional.of(params));
    }

    @Test(expected = GeneratorExeption.class)
    public void whenPatternNullAndThreeParamSetsThenGeneratesException() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("name", "Aleksey");
        params.put("subject", "you");
        params.put("any", "blabla");

        SimpleGenerator generator = new SimpleGenerator();

        generator.generate(Optional.empty(), Optional.of(params));
    }

    @Test(expected = GeneratorExeption.class)
    public void whenParamsNullThenGeneratesException() throws Exception {
        String pattern =  "I am a ${name}, Who are ${subject}? ";
        SimpleGenerator generator = new SimpleGenerator();

        generator.generate(Optional.of(pattern), Optional.empty());
    }



}