package ru.job4j.tracker;


import ru.job4j.tracker.sql.ITracker;


import java.util.function.Consumer;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 11.09.2018
 */

public class StartUI {
    private ITracker tracker;
    private Input input;
    private boolean work = true;
    private Consumer<String> consumer;

    public StartUI(Input input, ITracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.consumer = output;
    }

    /**
     * метод для смены флага способствующий остановке программы
     */
    public void stop() {
        this.work = false;
    }

    /**
     * Основной метод для инициалазии программы
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, System.out::println);
        menu.fillActions(this);
        do {
            this.consumer.accept("-----------MENU--------");
            menu.show();
            this.consumer.accept("-----------------------");
            int key = (input.ask("select: ", System.out::println, menu.fillRange()));
            menu.select(key);
        } while (this.work);
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }
}
