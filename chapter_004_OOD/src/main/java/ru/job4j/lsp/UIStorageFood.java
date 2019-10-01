package ru.job4j.lsp;

import ru.job4j.lsp.action.AddFoodProcessing;
import ru.job4j.lsp.input.ConsoleInput;
import ru.job4j.lsp.input.InputInterface;
import ru.job4j.lsp.storage.Reproduct;
import ru.job4j.lsp.storage.Storage;

import java.util.ArrayList;
import java.util.List;


public class UIStorageFood {
    private boolean work = true;
    private final MenuStorage menu;
    private final InputInterface input;
    private final List<Storage> storages;

    void setWork(boolean work) {
        this.work = work;
    }

    public UIStorageFood(MenuStorage menu, InputInterface input, List<Storage> storages) {
        this.menu = menu;
        this.input = input;
        this.storages = storages;
    }

    public List<Storage> getStorages() {
        return storages;
    }

    public void execute() {
        this.menu.fillDefaultAction(this);
        do {
            menu.show();
            int key = input.ask("Input action ", menu.fillRange());
            menu.select(key, this, input);
        } while (this.work);


    }

    public static void main(String[] args) {
        List<Storage> storages = new ArrayList<>();
        MenuStorage menu = new MenuStorage();
        menu.addAction(new AddFoodProcessing(menu.sizeMenu(), AddFoodProcessing.class.getSimpleName()));
        storages.add(new Reproduct());

        new UIStorageFood(menu, new ConsoleInput(), storages).execute();

    }
}
