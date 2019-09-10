package ru.job4j.lsp.storage;

import ru.job4j.lsp.model.Food;

import java.util.List;

public interface Storage {
    void add(Food food);
    boolean accept(Food food);
    void show();
    List<Food> getFoods();
}
