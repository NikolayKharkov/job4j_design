package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.ConcurrentModificationException;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size = 0;

    private int modCount = 0;

    private int expectedModCount = 0;

    private int iteratorSize = 0;

    public SimpleArrayList() {
        this.container = (T[]) new Object[10];
    }

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    private T[] grow() {
        return this.container.length == 0
                ? Arrays.copyOf(container, 1) : Arrays.copyOf(container, container.length * 2);
    }

    @Override
    public void add(T value) {
        if (size == this.container.length) {
            container = grow();
            container[size] = value;
            size++;
            modCount++;
        }
        container[size] = value;
        size++;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        T result = get(index);
        container[index] = newValue;
        modCount++;
        return result;
    }

    @Override
    public T remove(int index) {
        T result = get(index);
        System.arraycopy(
                container,
                index + 1,
                container,
                index,
                container.length - index - 1
        );
        container[size - 1] = null;
        size--;
        modCount++;
        return result;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        expectedModCount = this.modCount;
        iteratorSize = 0;
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return iteratorSize < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[iteratorSize++];
            }
        };
    }
}
