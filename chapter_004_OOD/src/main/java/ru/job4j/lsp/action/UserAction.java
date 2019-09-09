package ru.job4j.lsp.action;

import ru.job4j.lsp.UIStorageFood;

public interface UserAction {
    int key(int key);
    void execute(UIStorageFood ui);
    String info();
}
