package ru.job4j.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 24.03.2019
 */

public class AbusesWords {
    /**
     * Метод использую сканер забирает из потока строку удаляет запретные слова и записывает в
     * исходящий поток
     *
     * @param in    - входящий поток
     * @param out   - исходящий поток
     * @param words - массив с запретными словами
     * @throws IOException
     */
    public void dropAbuses(InputStream in, OutputStream out, String[] words) throws IOException {
        Scanner scanner = new Scanner(in);
        while (scanner.hasNext()) {
            out.write(removeWord(scanner.nextLine(), words).getBytes());
        }
    }

    /**
     * Метод удаляет из строки все элементы из массива words
     *
     * @param inLine - входящая строка
     * @param words  - массив с запретными словами
     * @return - строка без запретных слов
     */
    private String removeWord(String inLine, String[] words) {
        String rst = inLine;
        for (String word : words) {
            rst = rst.replace(word, "");
        }
        return rst;
    }
}
