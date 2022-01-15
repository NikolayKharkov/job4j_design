package ru.job4j.ood.products;

import java.util.ArrayList;
import java.util.List;

public class Trash implements FoodStorage {

    private List<Food> trash = new ArrayList<>();

    @Override
    public void putFood(Food food) {
        trash.add(food);
    }

    @Override
    public List<Food> getFoods() {
        return trash;
    }
}
