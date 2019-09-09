package ru.job4j.lsp;

import ru.job4j.lsp.input.ConsoleInput;
import ru.job4j.lsp.input.InputInterface;
import ru.job4j.lsp.storage.Shop;
import ru.job4j.lsp.storage.Storage;
import ru.job4j.lsp.storage.Trash;
import ru.job4j.lsp.storage.Warehouse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class UIStorageFood {
    public boolean work = true;
    private final MenuStorage menu;
    private final InputInterface input;
    private List<Storage> storages = new ArrayList<>(Arrays.asList(new Shop(), new Trash(), new Warehouse()));
//    private Storage shop = new Shop();
//    private Storage trash = new Trash();
//    private Storage warehouse = new Warehouse();

    public UIStorageFood(MenuStorage menu, InputInterface input) {
        this.menu = menu;
        this.input = input;
    }

    public List<Storage> getStorages() {
        return storages;
    }

    public void execute() {
        this.menu.fillAction(this);
        do {
            menu.show();
            int key = input.ask("Input action ", menu.fillRange());
            menu.select(key,this);
        } while (this.work);


    }

    public static void main(String[] args) {
        new UIStorageFood(new MenuStorage(), new ConsoleInput()).execute();
    }
}
