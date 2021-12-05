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

    int expectedModCount = 0;

    int iteratorSize = 0;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (size == this.container.length) {
            container = Arrays.copyOf(container, container.length * 2);
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
        T result = container[Objects.checkIndex(index, size)];
        container[index] = newValue;
        modCount++;
        return result;
    }

    @Override
    public T remove(int index) {
        T result = container[Objects.checkIndex(index, size)];
        System.arraycopy(
                container,
                index + 1,
                container,
                index,
                container.length - index - 1
        );
        container[container.length - 1] = null;
        size--;
        modCount++;
        return result;
    }

    @Override
    public T get(int index) {
        return container[Objects.checkIndex(index, size)];
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
