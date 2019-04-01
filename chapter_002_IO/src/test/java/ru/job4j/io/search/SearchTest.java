package ru.job4j.io.search;


import org.junit.Test;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 02.04.2019
 */

public class SearchTest {
    private static final String SR = File.separator;

    @Test
    public void whenTwoFilesExtentionJpg() throws IOException {
        String path = System.getProperty("java.io.tmpdir") + "chapter_002_IO" + SR;
        Search.clearDir(path);
        File root = new File(path);
        File inRoot = new File(root.getPath());
        File fileOne = new File(root, "123.jpg");
        File fileTwo = new File(root, "hello.txt");
        File fileThree = new File(root, "photo.jpg");
        File fileFour = new File(inRoot, "table.xlsx");
        root.mkdir();
        inRoot.mkdir();
        fileOne.createNewFile();
        fileTwo.createNewFile();
        fileThree.createNewFile();
        fileFour.createNewFile();
        assertThat(new Search().files(path, new String[]{"jpg"}), is(new ArrayList<>(Arrays.asList(fileOne, fileThree))));
    }

    @Test
    public void whenOneFileExtentionXlsx() throws IOException {
        String path = System.getProperty("java.io.tmpdir") + "chapter_002_IO" + SR;
        Search.clearDir(path);
        File root = new File(path);
        File inRoot = new File(root.getPath());
        File fileOne = new File(root, "123.jpg");
        File fileTwo = new File(root, "hello.txt");
        File fileThree = new File(root, "photo.jpg");
        File fileFour = new File(inRoot, "table.xlsx");
        root.mkdir();
        inRoot.mkdir();
        fileOne.createNewFile();
        fileTwo.createNewFile();
        fileThree.createNewFile();
        fileFour.createNewFile();
        assertThat(new Search().files(path, new String[]{"xlsx"}), is(new ArrayList<>(Arrays.asList(fileFour))));
    }

    @Test
    public void whenThreeFilesExtentionJpgAndTxt() throws IOException {
        String path = System.getProperty("java.io.tmpdir") + "chapter_002_IO" + SR;
        Search.clearDir(path);
        File root = new File(path);
        File inRoot = new File(root.getPath());
        File fileOne = new File(root, "123.jpg");
        File fileTwo = new File(root, "hello.txt");
        File fileThree = new File(root, "photo.jpg");
        File fileFour = new File(inRoot, "table.xlsx");
        root.mkdir();
        inRoot.mkdir();
        fileOne.createNewFile();
        fileTwo.createNewFile();
        fileThree.createNewFile();
        fileFour.createNewFile();
        assertThat(new Search().files(path, new String[]{"jpg", "txt"}), is(
                new ArrayList<>(Arrays.asList(fileOne, fileTwo, fileThree))));
    }


}
