package ru.job4j.lsp.action;

import ru.job4j.lsp.UIStorageFood;

public class ShowTrash extends BaseAction {
    public ShowTrash(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(UIStorageFood ui) {
        //ui.getTrash().show();
    }
}
