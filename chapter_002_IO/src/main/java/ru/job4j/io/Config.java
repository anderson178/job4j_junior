package ru.job4j.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 12.04.2019
 */

public class Config {
    private final String path;
    private Map<String, String> map = new HashMap<>();
    private final static String SR = File.separator;
    private final static String LS = System.lineSeparator();

    public Config(String path) {
        this.path = path;
    }

    /**
     * Метод считывает содержимое файла и парсит в Map исключая пустые строки и комментарии
     *
     * @return
     */
    public Map load() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.path))) {
            bufferedReader.lines().forEach(line -> {
                if (!line.equals("") && !this.existComment(line) && line.contains("=")) {
                    String[] split = line.split("=");
                    this.map.put(split[0], split[1]);
                }
            });

        }
        return this.map;
    }

    /**
     * Метод проверяет наличие комментария в строке
     *
     * @param line - считываемая строка
     * @return
     */

    private boolean existComment(String line) {
        return line.length() > 1 && (line.substring(0, 1).equals("#"));
    }


}
