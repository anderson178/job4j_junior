package ru.job4j.lsp.action;

import ru.job4j.lsp.UIStorageFood;

public class AddFood extends BaseAction {
    public AddFood(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(UIStorageFood ui) {
        System.out.println(this.getClass().getSimpleName() + " ==== hi");
    }
}
