package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int iteratorSize = 0;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean result = false;
        if ((float) count / (float) capacity >= LOAD_FACTOR) {
            expand();
        }
        int indexPut = key == null ? 0 : indexFor(hash(key.hashCode()));
        if (table[indexPut] == null) {
            table[indexPut] = new MapEntry<>(key, value);
            result = true;
            modCount++;
            count++;
        }
        return result;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] expandbleTable = new MapEntry[capacity];
        for (MapEntry<K, V> el : table) {
            if (el != null) {
                expandbleTable[el.key == null ? 0 : indexFor(hash(el.key.hashCode()))] = el;
            }
        }
        table = expandbleTable;
    }

    @Override
    public V get(K key) {
        int indexGet = key == null ? 0 : indexFor(hash(key.hashCode()));
        return table[indexGet] == null ? null : table[indexGet].value;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        int indexRemove = key == null ? 0 : indexFor(hash(key.hashCode()));
        if (table[indexRemove] != null) {
            table[indexRemove] = null;
            count--;
            modCount++;
            result = true;
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        final int expectedModCount = this.modCount;
        iteratorSize = 0;
        return new Iterator<K>() {

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (iteratorSize < capacity && table[iteratorSize] == null) {
                    iteratorSize++;
                }
                return iteratorSize < capacity && table[iteratorSize] != null;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[iteratorSize++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}