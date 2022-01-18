package ru.job4j.ood.products;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {

    private List<Food> storage = new ArrayList<>();

    @Override
    public boolean putFood(Food food) {
        boolean result = false;
        if (accept(food)) {
            storage.add(food);
            result = true;
        }
        return result;
    }

    @Override
    public boolean accept(Food food) {
        boolean result = false;
        if (food.isFresh() && returnExpirationPercent(food) < 25) {
            result = true;
        }
        return result;
    }

    @Override
    public List<Food> getFoods() {
        return List.copyOf(storage);
    }

    @Override
    public void removeAllProducts() {
        this.storage = new ArrayList<>();
    }
}
