package ru.job4j.it;


import org.junit.Test;
import static org.hamcrest.Matchers.is;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenAddAfterInMiddle() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 2, 3));
        ListUtils.addAfter(input, 0, 1);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenRemoveIfNotEven() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        Predicate<Integer> onlyEven = v -> v % 2 != 0;
        ListUtils.removeIf(input, onlyEven);
        assertThat(input, is(Arrays.asList(0, 2, 4)));
    }

    @Test
    public void whenRemoveIfBuntNotChange() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 2, 4));
        Predicate<Integer> onlyEven = v -> v % 2 != 0;
        ListUtils.removeIf(input, onlyEven);
        assertThat(input, is(Arrays.asList(0, 2, 4)));
    }

    @Test
    public void whenReplaceIfNotEven() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        Predicate<Integer> onlyEven = v -> v % 2 != 0;
        ListUtils.replaceIf(input, onlyEven, 0);
        assertThat(input, is(Arrays.asList(0, 0, 2, 0, 4, 0)));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        List<Integer> needDelete = new ArrayList<>(Arrays.asList(0, 1));
        ListUtils.removeAll(input, needDelete);
        assertThat(input, is(Arrays.asList(2, 3, 4, 5)));
    }
}