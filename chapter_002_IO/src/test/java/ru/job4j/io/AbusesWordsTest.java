package ru.job4j.io;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 24.03.2019
 */

public class AbusesWordsTest {
    private String path = "C://projects//job4j_junior//chapter_002_IO//src//main//resources//abusesWords//";
    private AbusesWords abusesWords = new AbusesWords();

    @Test
    public void whenAbusesWordsExistsTwoWordsWorldAndDo() {
        try (InputStream in = new FileInputStream(this.path + "inString1.txt")) {
            OutputStream out = new FileOutputStream(this.path + "outString1.txt");
            this.abusesWords.dropAbuses(in, out, new String[]{"world", "do"});
            Scanner scanner = new Scanner(new File(this.path + "outString1.txt"), "UTF-8");
            assertThat(scanner.nextLine(), is("Hello ! Just  it!"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenAbusesWordsExistsOneWordBestWithWhiteSpace() {
        try (InputStream in = new FileInputStream(this.path + "inString2.txt")) {
            OutputStream out = new FileOutputStream(this.path + "outString2.txt");
            this.abusesWords.dropAbuses(in, out, new String[]{"best "});
            Scanner scanner = new Scanner(new File(this.path + "outString2.txt"), "UTF-8");
            assertThat(scanner.nextLine(), is("today is the day"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
