package ru.job4j.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class SimpleMapTest {

    SimpleMap<String, Integer> map;

    @Before
    public void initData() {
        map = new SimpleMap<>();
    }

    @Test
    public void whenSinglePut() {
        Assert.assertTrue(map.put("Test", 1));
    }

    @Test
    public void whenDoublePut() {
        Assert.assertTrue(map.put("Test1", 1));
        Assert.assertTrue(map.put("Test2", 2));
    }

    @Test
    public void whenDoublePutButSecondFalse() {
        Assert.assertTrue(map.put("Test1", 1));
        Assert.assertFalse(map.put("Test1", 1));
    }

    @Test
    public void whenDoublePutThenGet() {
        map.put("Test1", 1);
        map.put("Test2", 2);
        Assert.assertEquals(Integer.valueOf(2), map.get("Test2"));
    }

    @Test
    public void whenDoublePutButBothKeysIsNull() {
        Assert.assertTrue(map.put(null, 1));
        Assert.assertFalse(map.put(null, 1));
    }

    @Test
    public void whenDoublePutButOneKeysIsNull() {
        Assert.assertTrue(map.put("Test2", 2));
        Assert.assertTrue(map.put(null, 1));
        Assert.assertEquals(Integer.valueOf(1), map.get(null));
    }

    @Test
    public void whenDoublePutThenGetAndReturnNull() {
        map.put("Test1", 1);
        map.put("Test2", 2);
        Assert.assertNull(map.get("Test3"));
    }

    @Test
    public void whenDoublePutThenRemove() {
        map.put("Test1", 1);
        map.put("Test2", 2);
        Assert.assertTrue(map.remove("Test1"));
        Assert.assertTrue(map.remove("Test2"));
    }

    @Test
    public void whenDoublePutThenRemoveFalse() {
        map.put("Test1", 1);
        map.put("Test2", 2);
        Assert.assertTrue(map.remove("Test1"));
        Assert.assertFalse(map.remove("Test3"));
    }

    @Test
    public void whenCheckExpand() {
        Assert.assertTrue(map.put("Test1", 1));
        Assert.assertTrue(map.put("Test2", 2));
        Assert.assertTrue(map.put("Test3", 3));
        Assert.assertTrue(map.put("Test4", 4));
        Assert.assertTrue(map.put("Test5", 5));
        Assert.assertTrue(map.put("Test6", 6));
        Assert.assertTrue(map.put("Test7", 7));
        Assert.assertTrue(map.put("Test8", 8));
        Assert.assertTrue(map.put("Test9", 9));
        Assert.assertTrue(map.put("Test10", 10));
        Assert.assertTrue(map.put("Test11", 11));
        Assert.assertTrue(map.put("Test12", 12));
        Assert.assertEquals(Integer.valueOf(12), map.get("Test12"));
        Assert.assertEquals(Integer.valueOf(1), map.get("Test1"));
        Assert.assertEquals(Integer.valueOf(7), map.get("Test7"));
    }

    @Test
    public void whenCheckIteratorWhenNoElements() {
        Iterator<String> it = map.iterator();
        Assert.assertFalse(it.hasNext());
    }

    @Test
    public void whenCheckIteratorWhenFewElements() {
        map.put("Test1", 1);
        map.put("Test2", 2);
        Iterator<String> it = map.iterator();
        Assert.assertTrue(it.hasNext());
        Assert.assertTrue("Test1".equals(it.next()));
        Assert.assertTrue(it.hasNext());
        Assert.assertTrue("Test2".equals(it.next()));
        Assert.assertFalse(it.hasNext());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenRemoveAfterGetIteratorThenMustBeException() {
        map.put("Test1", 1);
        Iterator<String> it = map.iterator();
        map.put("Test2", 2);
        it.next();
    }
}