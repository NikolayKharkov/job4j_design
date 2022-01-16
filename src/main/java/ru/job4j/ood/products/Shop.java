package ru.job4j.ood.products;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {

    private List<Food> shop = new ArrayList<>();

    @Override
    public boolean putFood(Food food) {
        boolean result = false;
        if (accept(food)) {
            if (returnExpirationPercent(food) >= 75) {
                food.setDiscount(15.0);
            }
            shop.add(food);
            result = true;
        }
        return result;
    }

    @Override
    public boolean accept(Food food) {
        boolean result = false;
        if (food.isFresh() && returnExpirationPercent(food) >= 25) {
            result = true;
        }
        return result;
    }

    @Override
    public List<Food> getFoods() {
        return List.copyOf(shop);
    }
}
