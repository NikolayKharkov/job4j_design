package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findValue(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findValue(value, comparator.reversed());
    }

    public <T> T findValue(List<T> value, Comparator<T> comparator) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException("value has no arguments!");
        }
        T result = value.get(0);
        for (int i = 1; i != value.size(); i++) {
            if (comparator.compare(result, value.get(i)) < 0) {
                result = value.get(i);
            }
        }
        return result;
    }
}