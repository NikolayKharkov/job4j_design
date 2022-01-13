package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GeneratorTest {

    @Ignore
    @Test
    public void whenPatternAndKeysIsCorrect() {
        Generator gen = new UserGenerator();
        String pattern = "Hello i'm ${name}. I'm ${age} years old";
        String expected = "Hello i'm Nikolay. I'm 26 years old";
        Map<String, String> keys = Map.of("name", "Nikolay", "age", "26");
        assertThat(expected, is(gen.produce(pattern, keys)));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenPatternNotCorrect() {
        Generator gen = new UserGenerator();
        String pattern = "Hello i'm ${name}. I'm ${age} years old. I'm from ${country}";
        String expected = "Hello i'm Nikolay. I'm 26 years old. I'm from Russia";
        Map<String, String> keys = Map.of("name", "Nikolay", "age", "26");
        assertThat(expected, is(gen.produce(pattern, keys)));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenKeysNotCorrect() {
        Generator gen = new UserGenerator();
        String pattern = "Hello i'm ${name}. I'm ${age} years old.";
        String expected = "Hello i'm Nikolay. I'm 26 years old";
        Map<String, String> keys = Map.of("name", "Nikolay",
                "age", "26",
                "country", "Russia");
        assertThat(expected, is(gen.produce(pattern, keys)));
    }
}