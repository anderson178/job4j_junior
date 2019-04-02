package ru.job4j.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 02.4.2019
 */

public class ArgsZipTest {
    private static final String SR = File.separator;

    @Test
    public void tearArchive() throws IOException {

        String pathFiles = System.getProperty("java.io.tmpdir") + SR + "chapter_002_IO";
        ArgsZip.clearDir(pathFiles);
        File rootFiles = new File(pathFiles);
        rootFiles.mkdir();
        String pathArch = System.getProperty("java.io.tmpdir") + SR + "archive";
        ArgsZip.clearDir(pathArch);
        File rootArch = new File(pathArch);
        rootArch.mkdir();
        File first = new File(rootFiles, "123.png");
        first.createNewFile();
        File second = new File(rootFiles, "456.txt");
        second.createNewFile();
        File third = new File(rootFiles, "789.jpg");
        third.createNewFile();
        File fourth = new File(rootFiles, "003.txt");
        fourth.createNewFile();
        File rootIn = new File(rootFiles, "folder");
        rootIn.mkdir();
        File fifth = new File(rootIn, "222.png");
        fifth.createNewFile();
        String[] args = new String[]{"-d", pathFiles + SR, "-e", "*.txt", "-o", pathArch + SR + "project.zip"};
        ArgsZip arch = new ArgsZip(args);
        arch.archive();
        List<String> expected = new ArrayList<>(Arrays.asList(first.getName(), third.getName(),
                rootIn.getName() + SR + fifth.getName()));
        try (ZipInputStream zip = new ZipInputStream(new FileInputStream(new File(pathArch + SR + "project.zip")))) {
            List<String> rst = new ArrayList<>();
            ZipEntry zipEntry;
            while ((zipEntry = zip.getNextEntry()) != null) {
                rst.add(zipEntry.getName());
            }
            assertThat(rst.containsAll(expected), is(true));
        }
    }


}
