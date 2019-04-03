package ru.job4j.io.chat;


import java.io.*;
import java.util.*;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 07.04.2019
 */

public class Action {
    private static final String LS = System.lineSeparator();
    private static final Random RN = new Random();

    /**
     * Метод для создания директории
     *
     * @param pathDirectoy
     */
    protected void createDir(String pathDirectoy) {
        new File(pathDirectoy).mkdir();
    }

    /**
     * Метод удаления директории и ее содержимого
     *
     * @param pathDirectoy
     */
    protected void removeDir(String pathDirectoy) {
        if (new File(pathDirectoy).exists()) {
            LinkedList<File> directorys = new LinkedList<>();
            directorys.offer(new File(pathDirectoy));
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
            new File(pathDirectoy).delete();
        }
    }

    /**
     * Метод для записи в файл. Дописывает к существующим данным в файле
     *
     * @param who  - кто совершил действие (пользователь/бот)
     * @param ask  - вводимая строка (вопрос/ответ)
     * @param path - путь до файлы хранящий логи
     * @throws IOException
     */
    public void writeFile(String who, String ask, String path) throws IOException {
        File file = new File(path);
        file.createNewFile();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getPath(), true))) {
            bufferedWriter.write(who + " - " + ask + LS);
        }
    }

    /**
     * Метод сохраняет свловарный набор в файл
     *
     * @param path  - путь до файла хранящий словарь
     * @param words - словарь
     * @throws IOException
     */
    public void writeFile(String path, String words) throws IOException {
        File file = new File(path);
        file.createNewFile();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getPath()))) {
            bufferedWriter.write(words);
        }
    }

    /**
     * Метод считывает файл с словарем и добавляет в список
     *
     * @param path - путь до файла хранящий словарь
     * @return - список с словами из словаря
     */
    protected List<String> fillWords(String path) {
        List<String> rst = new ArrayList<>();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(path)))) {
            while (scanner.hasNext()) {
                rst.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return rst;
    }

    /**
     * Метод получения слова из словаря. Берется случайное
     *
     * @param words - список с словами
     * @return - слово из словаря
     */
    public String getWord(List<String> words) {
        int index = Math.abs(RN.nextInt()) % words.size();
        System.out.println(words.get(index));
        return words.get(index);
    }
}
