package ru.job4j.lsp.storage;

import ru.job4j.lsp.model.Food;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

public class Trash implements Storage {
    private List<Food> foodList = new ArrayList<>();
    @Override
    public void add(Food food) {
        this.foodList.add(food);
    }

    @Override
    public boolean accept(Food food) {
        return food.getExpiryDate().before(new Date(System.currentTimeMillis()));
    }

    @Override
    public void show() {
        IntStream.range(0, this.foodList.size()).forEach(i
                -> System.out.println(getClass().getSimpleName() + " " + i + ":" + " " + this.foodList.get(i)));
    }

    @Override
    public List<Food> getFoods() {
        return foodList;
    }

}
