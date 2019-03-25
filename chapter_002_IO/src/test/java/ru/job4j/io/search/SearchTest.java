package ru.job4j.io.search;

import org.junit.Before;
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
 * @since 25.03.2019
 */

public class SearchTest {
    private String path = System.getProperty("java.io.tmpdir") + "chapter_002_IO";
    private File root = new File(path);
    private File inRoot = new File(root.getPath());
    private File fileOne = new File(root, "123.jpg");
    private File fileTwo = new File(root, "hello.txt");
    private File fileThree = new File(root, "photo.jpg");
    private File fileFour = new File(inRoot, "table.xlsx");

    @Before
    public void setUp() throws IOException {
        root.mkdir();
        inRoot.mkdir();
        fileOne.createNewFile();
        fileTwo.createNewFile();
        fileThree.createNewFile();
        fileFour.createNewFile();
    }

    @Test
    public void whenTwoFilesExtentionJpg() {
        assertThat(new Search().files(path, new String[]{"jpg"}), is(new ArrayList<>(Arrays.asList(fileOne, fileThree))));
    }

    @Test
    public void whenOneFileExtentionXlsx() {
        assertThat(new Search().files(path, new String[]{"xlsx"}), is(new ArrayList<>(Arrays.asList(fileFour))));
    }

    @Test
    public void whenThreeFilesExtentionJpgAndTxt() {
        assertThat(new Search().files(path, new String[]{"jpg", "txt"}), is(
                new ArrayList<>(Arrays.asList(fileOne, fileTwo, fileThree))));
    }


}
