package ru.job4j.kiss;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class MaxMinTest extends MaxMin {

    final List<Integer> list = List.of(1, 2, -6, 100, -6, 3, 8);

    @Test
    public void whenSearchMax() {
        Assert.assertThat(100, is(max(list, Integer::compareTo)));
    }

    @Test
    public void whenSearchMin() {
        Assert.assertThat(-6, is(min(list, Integer::compareTo)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNoArguments() {
        max(Collections.emptyList(), Integer::compareTo);
    }
}