package ru.job4j.ood.products;

import java.util.List;

public interface FoodStorage {
    public void putFood(Food food);

    public List<Food> getFoods();
}
