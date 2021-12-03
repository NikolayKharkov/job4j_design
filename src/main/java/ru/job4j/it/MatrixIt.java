package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = row; i < data.length; i++) {
            if (data[i].length != 0 || column < data[i].length) {
                result = true;
                break;
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
        for (int i = row; i != data.length; i++) {
            if (data[i].length == 0) {
                continue;
            }
            if (data[i].length == 1) {
                result = data[i][0];
                this.row = i + 1;
                this.column = 0;
                break;
            }
            if (column < data[i].length && (data[i].length != 1 || data[i].length != 0)) {
                result = data[i][column];
                this.row = i;
                this.column++;
                break;
            }
            if (column >= data[i].length && (data[i].length != 1 || data[i].length != 0)) {
                result = data[i++][0];
                this.row = i + 1;
                this.column = 0;
                break;
            }
        }
        return result;
    }
}