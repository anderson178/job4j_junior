package ru.job4j.lsp.action;

import ru.job4j.lsp.UIStorageFood;
import ru.job4j.lsp.input.InputInterface;
import ru.job4j.lsp.storage.Storage;

public class ShowStorages extends BaseAction {

    public ShowStorages(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(UIStorageFood ui, InputInterface input) {
        System.out.println("----------RESULT------");
        ui.getStorages().forEach(Storage::show);
        System.out.println("-----------------------");
    }
}
