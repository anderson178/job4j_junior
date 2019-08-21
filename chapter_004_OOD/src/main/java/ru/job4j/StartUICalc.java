package ru.job4j;

import ru.job4j.srp.ordinaryCalc.ConsoleInput;
import ru.job4j.srp.ordinaryCalc.Input;
import ru.job4j.srp.ordinaryCalc.MenuCalculator;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 14.08.2019
 */
public class StartUICalc {
    private MenuCalculator menu;
    private Input input;
    public Double result = 0.0;
    public boolean work = true;

    public StartUICalc(Input input, MenuCalculator menu) {
        this.input = input;
        this.menu = menu;
    }

    /**
     * Ask input to actions user and execute the actions
     */
    public void execute() {
        menu.fillActions(this);
        do {
            this.menu.show();
            int key = input.ask("select: ", menu.fillRange());
            if (key == 4 || key == 5) {
                this.menu.select(key);
            } else {
                if (this.result.equals(0.0)) {
                    this.result = this.menu.select(key, input.askNumber("Input first number "),
                            input.askNumber("Input second number "));
                    System.out.println(this.result);
                } else {
                    this.result = this.menu.select(key, result, input.askNumber("Input second number "));
                    System.out.println(this.result);
                }
            }
        } while (work);
    }

//    public void execute() {
//        menu.fillActions(this);
//        do {
//            this.menu.show();
//            int key = input.ask("select: ", menu.fillRange());
//            if (key == 4 || key == 5) {
//                this.menu.select(key);
//            } else {
//                if (this.result.equals(0.0)) {
//                    this.result = this.menu.select(key, input.askNumber("Input first number "),
//                            input.askNumber("Input second number "));
//                    System.out.println(this.result);
//                } else {
//                    this.result = this.menu.select(key, result, input.askNumber("Input second number "));
//                    System.out.println(this.result);
//                }
//            }
//        } while (work);
//    }

    public static void main(String[] args) {
        new StartUICalc(new ConsoleInput(), new MenuCalculator()).execute();
    }
}
