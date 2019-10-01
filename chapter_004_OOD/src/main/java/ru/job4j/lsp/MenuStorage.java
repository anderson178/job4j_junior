package ru.job4j.lsp;

import ru.job4j.lsp.action.BaseAction;
import ru.job4j.lsp.action.ShowStorages;
import ru.job4j.lsp.action.UserAction;
import ru.job4j.lsp.input.InputInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MenuStorage {
    private List<UserAction> userActions = new ArrayList<>();
    private List<Integer> range = new ArrayList<>();

    public void fillDefaultAction(UIStorageFood ui) {
        this.userActions.add(new ShowStorages(this.userActions.size(), ShowStorages.class.getSimpleName()));
        this.userActions.add(new Exit(this.userActions.size(), Exit.class.getSimpleName(), ui));
    }

    public void addAction(UserAction action) {
        this.userActions.add(action);
    }

    public int sizeMenu() {
        return this.userActions.size();
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

    public void select(int key, UIStorageFood ui, InputInterface input) {
        this.userActions.get(key).execute(ui, input);
    }

    private class Exit extends BaseAction {
        private final UIStorageFood ui;

        public Exit(int key, String info, UIStorageFood ui) {
            super(key, info);
            this.ui = ui;
        }

        @Override
        public void execute(UIStorageFood ui, InputInterface input) {
            ui.setWork(false);
        }
    }

}
