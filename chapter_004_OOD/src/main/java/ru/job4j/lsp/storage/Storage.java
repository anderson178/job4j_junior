package ru.job4j.lsp.storage;

import ru.job4j.lsp.model.Food;

public interface Storage {
    void add(Food food);
    void show();

}
