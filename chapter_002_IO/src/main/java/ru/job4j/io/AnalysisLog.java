package ru.job4j.io;

import java.io.*;
import java.util.*;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 12.04.2019
 */

public class AnalysisLog {
    private static final String SR = File.separator;
    private static final String LS = System.lineSeparator();
    private boolean status = true;

    /**
     * Метод выявляет интервалы простоя узла
     *
     * @param logPath - путь к журналу со временем доступности и недоступности узла
     * @param targetPath - путь к файлу в который будет загружать результат анализа лога
     * @throws IOException
     */
    public void unavailable(String logPath, String targetPath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(logPath))) {
            List<String> interval = new ArrayList<>();
            br.lines().forEach(line -> {
                if (this.status != this.getStatus(line.split("\\s+")[0])) {
                    interval.add(line.split("\\s+")[1]);
                }
                this.status = this.getStatus(line.split("\\s+")[0]);
            });
            if (interval.size() % 2 != 0) {
                interval.add(interval.get(interval.size() - 1));
            }
            this.writeFile(this.fillString(interval), targetPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод формирования строки для последующей ее записи в файл
     *
     * @param interval - список с интервалами простоая узла
     * @return - строка с интервалами разделенными между собой переносом строки
     */
    private String fillString(List<String> interval) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < interval.size(); i = i + 2) {
            if (i != interval.size() - 2) {
                stringBuilder.append(interval.get(i) + ":" + interval.get(i + 1) + LS);
            } else {
                stringBuilder.append(interval.get(i) + ":" + interval.get(i + 1));
            }
        }
        return stringBuilder.toString();


    }

    /**
     * Метод определения статуса доступности узла
     *
     * @param type - команда
     * @return - если доступен то true Иначе false
     */
    private boolean getStatus(String type) {
        return type.equals("200") || type.equals("300");
    }

    /**
     * Метод создает файл в указанной директории
     *
     * @param path - путь к директории
     * @param name - наименование файла
     * @throws IOException
     */
    public void createFile(String path, String name) throws IOException {
        new File(path).mkdir();
        new File(path + SR + name).createNewFile();
    }

    /**
     * Метод удаления директорпии м ее содержимого
     *
     * @param pathDirectory
     */
    public void removeDir(String pathDirectory) {
        if (new File(pathDirectory).exists()) {
            LinkedList<File> directorys = new LinkedList<>();
            directorys.offer(new File(pathDirectory));
            while (!directorys.isEmpty()) {
                File file = directorys.poll();
                File[] dir = file.listFiles();
                if (file.isDirectory() && dir.length != 0) {
                    for (File directory : dir) {
                        directorys.offer(directory);
                    }
                } else {
                    file.delete();
                }
            }
            new File(pathDirectory).delete();
        }
    }

    /**
     * Метод записи текста в файл
     *
     * @param text
     * @param path
     * @throws IOException
     */
    public void writeFile(String text, String path) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(text);
        }
    }

    /**
     * Метод считывание содержимого файла
     *
     * @param path - путь к файлу
     * @return - список с строками
     * @throws IOException
     */
    public List readFile(String path) throws IOException {
        List<String> rst = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.lines().forEach(rst::add);
        }
        return rst;
    }
}
