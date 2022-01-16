package ru.job4j.ood.products;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControllQualityTest {

    @Test
    public void whenPutExpiredProduct() {
        ControllQuality quality = new ControllQuality(List.of(new Trash(), new Warehouse(), new Shop()));
        Milk expected = new Milk("Product", "2022-01-01", "2022-01-14", 100.0);
        quality.putProduct(expected);
        Assert.assertEquals(expected, quality.getProducts().get(0));
    }

    @Test
    public void whenPutProductGoToWareHouse() {
        ControllQuality quality = new ControllQuality(List.of(new Trash(), new Warehouse(), new Shop()));
        Meat expected = new Meat("Product", "2022-01-01", "2022-03-15", 100.0);
        quality.putProduct(expected);
        Assert.assertEquals(expected, quality.getProducts().get(0));
    }

    @Test
    public void whenPutProductGoToShopWithoutDiscount() {
        ControllQuality quality = new ControllQuality(List.of(new Trash(), new Warehouse(), new Shop()));
        Fruit expected = new Fruit("Product", "2022-01-01", "2022-02-15", 100.0);
        quality.putProduct(expected);
        Assert.assertEquals(expected, quality.getProducts().get(0));
    }

    @Test
    public void whenPutProductGoToShopWithDiscount() {
        ControllQuality quality = new ControllQuality(List.of(new Trash(), new Warehouse(), new Shop()));
        Fruit expected = new Fruit("Product", "2022-01-01", "2022-01-17", 100.0);
        quality.putProduct(expected);
        expected.setDiscount(15.0);
        Assert.assertEquals(expected, quality.getProducts().get(0));
    }

    @Test
    public void whenPutAFewProducts() {
        ControllQuality quality = new ControllQuality(List.of(new Trash(), new Warehouse(), new Shop()));
        List<Food> foodsExpected = new ArrayList<>();
        Fruit trashFood1 = new Fruit("Product1", "2022-01-01", "2022-01-14", 100.0);
        Milk trashFood2 = new Milk("Product2", "2022-01-01", "2022-01-05", 100.0);
        foodsExpected.add(trashFood1);
        foodsExpected.add(trashFood2);
        Meat wareFood1 = new Meat("Product3", "2022-01-01", "2022-03-15", 100.0);
        Fruit wareFood2 = new Fruit("Product4", "2022-01-01", "2022-03-20", 100.0);
        foodsExpected.add(wareFood1);
        foodsExpected.add(wareFood2);
        Milk shopFood1 = new Milk("Product5", "2022-01-01", "2022-02-15", 100.0);
        Milk shopFood2 = new Milk("Product6", "2022-01-01", "2022-01-17", 100.0);
        foodsExpected.add(shopFood1);
        quality.putProduct(trashFood1);
        quality.putProduct(trashFood2);
        quality.putProduct(wareFood1);
        quality.putProduct(wareFood2);
        quality.putProduct(shopFood1);
        quality.putProduct(shopFood2);
        shopFood2.setDiscount(15.0);
        foodsExpected.add(shopFood2);
        List<Food> result = quality.getProducts();
        Collections.sort(result);
        Assert.assertEquals(foodsExpected, result);
    }
}