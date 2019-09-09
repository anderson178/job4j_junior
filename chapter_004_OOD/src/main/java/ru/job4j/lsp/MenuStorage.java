package ru.job4j.lsp;

import ru.job4j.lsp.action.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MenuStorage {
    private List<UserAction> userActions = new ArrayList<>();
    private List<Integer> range = new ArrayList<>();

    public void fillAction(UIStorageFood ui) {
        this.userActions.add(new AddFood(this.userActions.size(), AddFood.class.getSimpleName()));
        this.userActions.add(new ShowShop(this.userActions.size(), ShowShop.class.getSimpleName()));
        this.userActions.add(new ShowTrash(this.userActions.size(), ShowTrash.class.getSimpleName()));
        this.userActions.add(new ShowWarehouse(this.userActions.size(), ShowWarehouse.class.getSimpleName()));
        this.userActions.add(new Exit(this.userActions.size(), Exit.class.getSimpleName(), ui));
    }

    public List<Integer> fillRange() {
        IntStream.range(0, this.userActions.size()).forEach(range::add);
        return this.range;
    }

    public void show() {
        System.out.println("-----------MENU--------");
        IntStream.range(0, this.userActions.size()).forEach(i
                -> System.out.println(i + ":" + " " + this.userActions.get(i).info()));
        System.out.println("-----------------------");
    }
    public void select(int key, UIStorageFood ui) {
        this.userActions.get(key).execute(ui);
    }

    private class Exit extends BaseAction {
        private final UIStorageFood ui;

        public Exit(int key, String info, UIStorageFood ui) {
            super(key, info);
            this.ui = ui;
        }

        @Override
        public void execute(UIStorageFood ui) {
            ui.setWork(false);
        }
    }

}
