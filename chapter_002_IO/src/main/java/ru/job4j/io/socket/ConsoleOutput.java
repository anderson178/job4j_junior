package ru.job4j.io.socket;


import java.util.ArrayList;
import java.util.List;


/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 17.04.2019
 */

public class ConsoleOutput implements Output {
    private List<String> text;
    private int position = 0;



    public ConsoleOutput(List<String> text) {
        this.text = text;
    }

    /**
     * Метод высчитывает случаное кол-во строк с фразами и эвыбирает так же случайным образом фразу
     *
     * @return
     */
    @Override
    public List<String> answer() {
        int randomCount = (int) (Math.random() * this.text.size());
        List<String> str = new ArrayList<>();
        for (int i = 0; i < randomCount; i++) {
            str.add(this.text.get((int) (Math.random() * this.text.size())));

        }
        return str;
    }
}
