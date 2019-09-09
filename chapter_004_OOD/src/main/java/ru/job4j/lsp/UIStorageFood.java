package ru.job4j.lsp;

import ru.job4j.lsp.input.ConsoleInput;
import ru.job4j.lsp.input.InputInterface;
import ru.job4j.lsp.storage.Shop;
import ru.job4j.lsp.storage.Trash;
import ru.job4j.lsp.storage.Warehouse;


public class UIStorageFood {
    public boolean work = true;
    private final MenuStorage menu;
    private final InputInterface input;
    private Shop shop = new Shop();
    private Trash trash = new Trash();
    private Warehouse warehouse = new Warehouse();

    public UIStorageFood(MenuStorage menu, InputInterface input) {
        this.menu = menu;
        this.input = input;
    }

    public Shop getShop() {
        return shop;
    }

    public Trash getTrash() {
        return trash;
    }

    public Warehouse getWarehouse() {
        return warehouse;
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
