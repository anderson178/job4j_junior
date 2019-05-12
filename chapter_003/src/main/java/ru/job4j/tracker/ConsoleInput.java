package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 10.09.2018
 */

public class ConsoleInput implements Input {
    private Scanner scaner = new Scanner(System.in);

   @Override
    /**
     * метод считывания данных с консоли введнные пользователем
     *
     * @param question - вопрос
     * @return - строку с считанными данными
     */
    public String ask(String question, Consumer<String> show) {
        show.accept(question);
        return this.scaner.nextLine();
    }

    @Override
    /**
     * метод валидации введенных данных при выборе меню
     *
     * @param question - вопрос
     * @param range    - набор чисел меню
     * @return - ключ иначе сообщение об ошибке
     */
    public int ask(String question, Consumer<String> show, ArrayList<Integer> range) {
        int key = Integer.valueOf(this.ask(question, System.out::println));
        boolean result = false;
        for (int value : range) {
            if (value == key) {
                result = true;
                break;
            }
        }
        if (!result) {
            throw new MenuOutExeption("out of menu range");
        } else {
            return key;
        }
    }

}
