package ru.job4j.io.archive;

import java.io.*;
import java.util.LinkedList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 02.4.2019
 */

public class ArgsZip {
    private String[] args;
    private String pathDirectoy;
    private String execude;
    private String nameOutFile;
    private final static String SR = File.separator;

    public ArgsZip(String[] args) {
        this.args = args;
    }

    /**
     * Метод архивирует содержимое указанно диркетории pathDirectory.
     * Перывй метод putNextEntry добавляет пустую папку.
     * Второй метод putNextEntry добавляет файлы расширения которых нет в списке execude.
     * Третий метод putNextEntry добавляет в случае когда в папке имеется файл исключения и нужно добавить
     * только папку.     *
     */
    public void archive() {
        parsingArgs();
        try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(this.nameOutFile))) {
            LinkedList<File> directorys = new LinkedList<>();
            directorys.offer(new File(this.pathDirectoy));
            while (!directorys.isEmpty()) {
                File file = directorys.poll();
                if (file.isDirectory()) {
                    File[] files = file.listFiles();
                    if (files.length != 0) {
                        for (File directory : files) {
                            directorys.offer(directory);
                        }
                    } else {
                        out.putNextEntry(new ZipEntry(file.getAbsolutePath().substring(this.pathDirectoy.length()) + SR));
                    }
                } else if (!execude.equals(file.getPath().split("\\.")[1])) {
                    out.putNextEntry(new ZipEntry(file.getAbsolutePath().substring(this.pathDirectoy.length() + 1)));
                } else if (!(file.getParent()).equals(pathDirectoy)) {
                    out.putNextEntry(new ZipEntry(file.getParent().substring(this.pathDirectoy.length()) + SR));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод парсит вхоядщий строковый массив
     */
    private void parsingArgs() {
      this.pathDirectoy = new ParsLine(this.args).getPathDirectoy();
      this.execude = new ParsLine(this.args).getExecude();
      this.nameOutFile = new ParsLine(this.args).getNameOutFile();
    }

    /**
     * Метод удаляет папку и ее содержимое
     *
     * @param pathDirectoy
     */
    public static void clearDir(String pathDirectoy) {
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

    public static void main(String[] args) {
        new ArgsZip(args).archive();
    }


}
