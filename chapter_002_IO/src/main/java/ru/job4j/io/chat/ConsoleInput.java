package ru.job4j.io.chat;

import java.util.Scanner;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 07.04.2019
 */

public class ConsoleInput implements Input {
    private Scanner scaner = new Scanner(System.in);

    /**
     * Метод считывает введеннную строку пользователем и возвращает ее
     *
     * @return - строка
     */
    @Override
    public String ask() {
        return scaner.nextLine();
    }
}
