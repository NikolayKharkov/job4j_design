package ru.job4j.ood.products;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ControllQualityTest {

    @Test
    public void whenPutExpiredProduct() {
        ControllQuality quality = new ControllQuality(new Trash(), new Warehouse(), new Shop());
        Food expected = new Food("Product", "2022-01-01", "2022-01-14", 100.0);
        quality.putProduct(expected);
        Assert.assertEquals(expected, quality.getTrashProducts().get(0));
    }

    @Test
    public void whenPutProductGoToWareHouse() {
        ControllQuality quality = new ControllQuality(new Trash(), new Warehouse(), new Shop());
        Food expected = new Food("Product", "2022-01-01", "2022-03-15", 100.0);
        quality.putProduct(expected);
        Assert.assertEquals(expected, quality.getWarehouseProducts().get(0));
    }

    @Test
    public void whenPutProductGoToShopWithoutDiscount() {
        ControllQuality quality = new ControllQuality(new Trash(), new Warehouse(), new Shop());
        Food expected = new Food("Product", "2022-01-01", "2022-02-15", 100.0);
        quality.putProduct(expected);
        Assert.assertEquals(expected, quality.getShopProducts().get(0));
    }

    @Test
    public void whenPutProductGoToShopWithDiscount() {
        ControllQuality quality = new ControllQuality(new Trash(), new Warehouse(), new Shop());
        Food expected = new Food("Product", "2022-01-01", "2022-01-17", 100.0);
        quality.putProduct(expected);
        expected.setDiscount(15.0);
        Assert.assertEquals(expected, quality.getShopProducts().get(0));
    }

    @Test
    public void whenPutAFewProducts() {
        ControllQuality quality = new ControllQuality(new Trash(), new Warehouse(), new Shop());
        List<Food> trashExpected = new ArrayList<>();
        Food trashFood1 = new Food("Product1", "2022-01-01", "2022-01-14", 100.0);
        Food trashFood2 = new Food("Product2", "2022-01-01", "2022-01-05", 100.0);
        trashExpected.add(trashFood1);
        trashExpected.add(trashFood2);
        List<Food> wareExpected = new ArrayList<>();
        Food wareFood1 = new Food("Product3", "2022-01-01", "2022-03-15", 100.0);
        Food wareFood2 = new Food("Product4", "2022-01-01", "2022-03-20", 100.0);
        wareExpected.add(wareFood1);
        wareExpected.add(wareFood2);
        List<Food> shopExpected = new ArrayList<>();
        Food shopFood1 = new Food("Product5", "2022-01-01", "2022-02-15", 100.0);
        Food shopFood2 = new Food("Product6", "2022-01-01", "2022-01-17", 100.0);
        shopExpected.add(shopFood1);
        quality.putProduct(trashFood1);
        quality.putProduct(trashFood2);
        quality.putProduct(wareFood1);
        quality.putProduct(wareFood2);
        quality.putProduct(shopFood1);
        quality.putProduct(shopFood2);
        shopFood2.setDiscount(15.0);
        shopExpected.add(shopFood2);
        Assert.assertEquals(trashExpected, quality.getTrashProducts());
        Assert.assertEquals(wareExpected, quality.getWarehouseProducts());
        Assert.assertEquals(shopExpected, quality.getShopProducts());
    }
}