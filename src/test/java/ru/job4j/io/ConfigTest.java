package ru.job4j.io;

import org.junit.Test;

import java.util.ConcurrentModificationException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenCorrectWithCommentsAndSpace() {
        String path = "./data/correct_with_coments.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Nikolay"));
        assertThat(config.value("lastName"), is("Kharkov"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenError() {
        String path = "./data/expected_error.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Nikolay"));
        assertThat(config.value("lastName"), is("Kharkov"));
    }
}
