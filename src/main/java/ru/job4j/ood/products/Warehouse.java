package ru.job4j.ood.products;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements FoodStorage {

    private List<Food> storage = new ArrayList<>();

    @Override
    public void putFood(Food food) {
        storage.add(food);
    }

    @Override
    public List<Food> getFoods() {
        return storage;
    }
}
