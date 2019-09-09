package ru.job4j.lsp;

import ru.job4j.lsp.input.ConsoleInput;
import ru.job4j.lsp.input.InputInterface;


public class UIStorageFood {
    public boolean work = true;
    private final MenuStorage menu;
    private final InputInterface input;

    public UIStorageFood(MenuStorage menu, InputInterface input) {
        this.menu = menu;
        this.input = input;
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
