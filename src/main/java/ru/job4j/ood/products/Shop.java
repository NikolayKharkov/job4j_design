package ru.job4j.ood.products;

import java.util.ArrayList;
import java.util.List;

public class Shop implements FoodStorage {

    private List<Food> shop = new ArrayList<>();

    @Override
    public void putFood(Food food) {
        shop.add(food);
    }

    @Override
    public List<Food> getFoods() {
        return shop;
    }
}
