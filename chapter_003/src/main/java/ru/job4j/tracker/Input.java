package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 31.08.2018
 */
public interface Input {
    String ask(String question, Consumer<String> show);

    int ask(String question, Consumer<String> show, ArrayList<Integer> range);
}
