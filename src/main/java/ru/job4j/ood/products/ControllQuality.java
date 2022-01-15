package ru.job4j.ood.products;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class ControllQuality {
    private Trash trash;
    private Warehouse warehouse;
    private Shop shop;

    public ControllQuality(Trash trash, Warehouse warehouse, Shop shop) {
        this.trash = trash;
        this.warehouse = warehouse;
        this.shop = shop;
    }

    public void putProduct(Food food) {
        if (food.isFresh()) {
            double expirePercent = returnExpirationPercent(food);
            if (expirePercent < 25) {
                warehouse.putFood(food);
            }
            if (expirePercent >= 25 && expirePercent < 75) {
                shop.putFood(food);
            }
            if (expirePercent >= 75) {
                food.setDiscount(15.0);
                shop.putFood(food);
            }
        } else {
            trash.putFood(food);
        }
    }

    private static double returnExpirationPercent(Food food) {
        LocalDate now = LocalDate.now();
        LocalDate createDate = food.getCreateDate();
        LocalDate expiryDate = food.getExpiryDate();
        Duration expirationDays = Duration.between(createDate.atStartOfDay(), expiryDate.atStartOfDay());
        Duration passedDays = Duration.between(createDate.atStartOfDay(), now.atStartOfDay());
        return Math.round((double) passedDays.toDays() / expirationDays.toDays() * 100);
    }

    public List<Food> getTrashProducts() {
        return trash.getFoods();
    }

    public List<Food> getWarehouseProducts() {
        return warehouse.getFoods();
    }

    public List<Food> getShopProducts() {
        return shop.getFoods();
    }
}
