package ru.job4j.io.search;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 02.04.2019
 */

public class Search {

    /**
     * метод используя алгоритм поиска в ширину проходит все поддиректории и добавляет в результиирующий лист
     * файлы расширения которых совпадает с заданными расширениями из входного массива
     * @param rootParh -  корневой путь
     * @param exts - набор расширений
     * @return - список файлов
     */
    public List<File> files(String rootParh, String[] exts) {
        List<File> listFiles = new ArrayList<>();
        LinkedList<File> directorys = new LinkedList<>();
        directorys.offer(new File(rootParh));
        while (!directorys.isEmpty()) {
            File file = directorys.poll();
            if (file.isDirectory()) {
                for (File directory : file.listFiles()) {
                        directorys.offer(directory);
                }
            } else if (this.checkExts(file, exts)) {
                listFiles.add(file);
            }
        }
        return listFiles;
    }

    /**
     * Метод проверяет соотвествует ли расширение файлы любому из заданного массива
     * @param file - файл
     * @param exts - набор расширений
     * @return
     */
    private boolean checkExts(File file, String[] exts) {
        boolean rst = false;
        String ex = file.getPath().split("\\.")[1];
        for (String extention : exts) {
            if (ex.equals(extention)) {
                rst = true;
                break;
            }
        }
        return rst;
    }

    /**
     * Метод удаляет папку и ее содержимое
     *
     * @param pathDirectoy - путь к директории
     */
    public static void clearDir(String pathDirectoy) {
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
        }
    }
}
