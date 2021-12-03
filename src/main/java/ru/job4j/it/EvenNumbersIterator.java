package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (index < data.length) {
            for (int i = index; i != data.length; i++) {
                if (data[i] % 2 == 0) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int result = 0;
        for (int i = index; i != data.length; i++) {
            if (data[i] % 2 == 0) {
                result = data[i];
                this.index = i + 1;
                break;
            }
        }
        return result;
    }
}