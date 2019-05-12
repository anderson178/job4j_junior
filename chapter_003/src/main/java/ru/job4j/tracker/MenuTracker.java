package ru.job4j.tracker;

import ru.job4j.tracker.sql.ITracker;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 05.10.2018
 */

public class MenuTracker {
    private Input input;
    private ITracker tracker;
    private ArrayList<UserAction> listActions = new ArrayList<>();
    private ArrayList<Integer> range = new ArrayList<>();
    private Consumer<String> consumer;

    public MenuTracker(Input input, ITracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.consumer = output;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.listActions.size();
    }

    /**
     * Метод заполнения меню.
     */
    public void fillActions(StartUI ui) {
        this.listActions.add(new AddItem(0, "ADD"));
        this.listActions.add(new ShowAllItem(1, "SHOW_ALL"));
        this.listActions.add(new EditItem(2, "EDIT"));
        this.listActions.add(new DeleteItem(3, "DELETE"));
        this.listActions.add(new FindByIdItem(4, "FIND_BY_ID"));
        this.listActions.add(new FinfByNameItem(5, "FIND_BY_NAME"));
        this.listActions.add(new Exit(6, "EXIT", ui));
    }

    /**
     * Метод заполнения числового интервала меню
     *
     * @return - интервал от 0 до значения размера массива
     */
    public ArrayList<Integer> fillRange() {
        for (int i = 0; i < this.getActionsLentgh(); i++) {
            range.add(i);
        }
        return this.range;
    }


    /**
     * метод выполнения команды меню по заданному ключу
     *
     * @param key
     */
    public void select(int key) {
        this.listActions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Вывод меню
     */
    public void show() {
        for (UserAction action : this.listActions) {
            if (action != null) {
                this.consumer.accept(action.info());
            }
        }
    }

    /**
     * Общий метод для вывода списка данных запроса
     *
     * @param items - массив заявок
     */
    private void showAllItems(List<Item> items) {
        if (items.size() != 0) {
            for (Item item : items) {
                this.consumer.accept(item.toString());
            }
        } else {
            this.consumer.accept("Список пуст");
        }
    }

    /**
     * внутренний класс для додавбления новой заявки
     */
    private class AddItem extends BaseAction {

        private AddItem(int key, String action) {
            super(key, action);
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            consumer.accept("You selection ADD");
            String name = input.ask("Please enter the task name: ", System.out::println);
            String desc = input.ask("Please enter the task description: ", System.out::println);
            tracker.add(new Item(name, desc));
            consumer.accept("Item create");
        }

    }

    /**
     * внутренний класс для вывода массива запрашиваемых заявок
     */
    private class ShowAllItem extends BaseAction {

        private ShowAllItem(int key, String action) {
            super(key, action);
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            List<Item> items = tracker.getAll();
            consumer.accept("You selection SHOW_ALL");
            showAllItems(items);
        }
    }

    /**
     * внутренний класс для редактирования заявок
     */
    private class EditItem extends BaseAction {

        private EditItem(int key, String action) {
            super(key, action);
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            consumer.accept("You selection EDIT");
            String id = input.ask("input id item:", System.out::println);
            String name = input.ask("input new name:", System.out::println);
            String desc = input.ask("input new description:", System.out::println);
            Item item = new Item(name, desc);
            if (tracker.edit(id, item)) {
                consumer.accept("Item is update");
            } else {
                consumer.accept("Item with id: " + id + " not found");
            }
        }
    }

    /**
     * внутренний класс для удаления заявок
     */
    private class DeleteItem extends BaseAction {

        private DeleteItem(int key, String action) {
            super(key, action);
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            consumer.accept("You selection DELETE");
            String id = input.ask("input id item:", System.out::println);
            if (tracker.remove(id)) {
                consumer.accept("Item remove");
            } else {
                consumer.accept("Item not found");
            }
        }

    }

    /**
     * внутренний класс для поиска заявки по id
     */
    private class FindByIdItem extends BaseAction {

        private FindByIdItem(int key, String action) {
            super(key, action);
        }

        private String toStringItem(String id, String name, String desc, String create) {
            return String.format("Item id: %s, Name: %s, Description: %s Create: %s", id, name, desc, create);
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            consumer.accept("You selection FIND_BY_ID");
            String id = input.ask("input id item:", System.out::println);
            Item item = tracker.findById(id);
            if (item != null) {
                consumer.accept(toStringItem(item.getId(), item.getName(), item.getDescription(), item.getCreate()));
            } else {
                consumer.accept("По данному id: " + id + " заявок не найдено");
            }
        }
    }

    /**
     * внутренний класс для поиска заявок по имени
     */
    private class FinfByNameItem extends BaseAction {

        private FinfByNameItem(int key, String action) {
            super(key, action);
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            consumer.accept("You selection FIND_BY_NAME");
            String name = input.ask("input name:", System.out::println);
            List<Item> items = tracker.findByName(name);
            showAllItems(items);
        }
    }

    /**
     * внутренний класс для выхода из программы
     */
    private class Exit extends BaseAction {
        private final StartUI ui;

        public Exit(int key, String action, StartUI ui) {
            super(key, action);
            this.ui = ui;
        }

        public void execute(Input input, ITracker tracker) {
            consumer.accept("You selection EXIT");
            consumer.accept("Goode bye");
            this.ui.stop();
        }
    }

}
