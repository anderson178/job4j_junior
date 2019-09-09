package ru.job4j.lsp.action;

import ru.job4j.lsp.UIStorageFood;

public class ShowShop extends BaseAction {
    public ShowShop(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(UIStorageFood ui) {
        //ui.getShop().show();
    }
}
