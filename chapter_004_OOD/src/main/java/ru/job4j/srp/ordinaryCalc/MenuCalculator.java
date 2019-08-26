package ru.job4j.srp.ordinaryCalc;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import ru.job4j.StartUICalc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 14.08.2019
 */

@FieldDefaults(level = AccessLevel.PRIVATE)
public class MenuCalculator {
    protected List<UserAction> userActions = new ArrayList<>();
    List<Integer> range = new ArrayList<>();
    private static final double ZERO = 0.0;


    /**
     * Fill a user action in the list
     *
     * @param ui
     */
    public void fillDefaultActions(StartUICalc ui) {
        userActions.add(new Clear(userActions.size(), Clear.class.getSimpleName(), ui));
        userActions.add(new Exit(userActions.size(), Exit.class.getSimpleName(), ui));
    }

    public void addAction(UserAction ua) {
        userActions.add(ua);
    }

    public int getSize() {
        return this.userActions.size();
    }

    /**
     * Fill range in the menu
     *
     * @return - list range
     */
    public List<Integer> fillRange() {
        IntStream.range(0, this.userActions.size()).forEach(range::add);
        return this.range;
    }

    /**
     * Call action  the necessary action
     *
     * @param key    - index action in the UserActions
     * @param first  - first number
     * @param second - second number
     * @return - result the action
     */
    public double select(int key, double first, double second) {
        return this.userActions.get(key).execute(first, second);
    }

    /**
     * Call action  the necessary action (for clean and exit)
     *
     * @param key - key
     */
    public void select(int key) {
        this.userActions.get(key).execute();
    }

    /**
     * Print of the menu
     */
    public void show() {
        System.out.println("-----------MENU--------");
        IntStream.range(0, this.userActions.size()).forEach(i
                -> System.out.println(i + ":" + " " + this.userActions.get(i).getInfo()));
        System.out.println("-----------------------");
    }


    /**
     * Clear class
     */
    private class Clear extends BaseAction {
        private final StartUICalc ui;

        public Clear(int key, String info, StartUICalc ui) {
            super(key, info);
            this.ui = ui;
        }

        @Override
        public double execute(double one, double two) {
            return 0.0;
        }

        public void execute() {
            this.ui.result = 0.0;
        }
    }

    /**
     * Exit class
     */
    private class Exit extends BaseAction {
        private final StartUICalc ui;

        public Exit(int key, String info, StartUICalc ui) {
            super(key, info);
            this.ui = ui;
        }

        @Override
        public double execute(double one, double two) {
            return 0.0;
        }

        public void execute() {
            this.ui.work = false;
        }
    }
}
