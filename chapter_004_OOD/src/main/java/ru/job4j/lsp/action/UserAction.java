package ru.job4j.lsp.action;

import ru.job4j.lsp.UIStorageFood;
import ru.job4j.lsp.input.InputInterface;

public interface UserAction {
    int key(int key);
    void execute(UIStorageFood ui, InputInterface input);
    String info();
}
