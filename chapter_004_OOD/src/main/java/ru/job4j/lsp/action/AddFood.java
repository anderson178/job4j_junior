package ru.job4j.lsp.action;

public class AddFood extends BaseAction {
    public AddFood(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute() {
        System.out.println(this.getClass().getSimpleName() + " ==== hi");
    }
}
