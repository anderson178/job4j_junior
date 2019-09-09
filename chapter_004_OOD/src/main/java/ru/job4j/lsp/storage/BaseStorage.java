package ru.job4j.lsp.storage;

import ru.job4j.lsp.model.Food;

public interface BaseStorage {
    void add(Food food);
    void show();

}
