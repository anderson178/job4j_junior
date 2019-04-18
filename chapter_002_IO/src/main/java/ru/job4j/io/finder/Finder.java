package ru.job4j.io.finder;

public class Finder {
    private String[] args;
    private ActionFind action;
    private ParsConsLIne console;

    public Finder(String[] args) {
        this.args = args;
        this.console = new ParsConsLIne(this.args);
    }

    public void find() {

        String flag = console.getFlag();
        String name = console.getName();
        String log = console.getPathLog();
        String dest = console.getPathDestenation();
        int p = 0;

    }


}
