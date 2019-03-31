package ru.job4j.io;

import org.junit.Test;
import ru.job4j.io.search.Search;

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
    private String path = "";
    private AbusesWords abusesWords = new AbusesWords();


    @Test
    public void whenAbusesWordsExistsTwoWordsWorldAndDo() {
        try (InputStream in = new FileInputStream(getClass().getClassLoader()
                .getResource("abusesWords/inString1.txt").toString().substring(5))) {
            OutputStream out = new FileOutputStream(getClass().getClassLoader()
                    .getResource("abusesWords/outString1.txt").toString().substring(5));
            this.abusesWords.dropAbuses(in, out, new String[]{"world", "do"});
            Scanner scanner = new Scanner(new File((getClass().getClassLoader()
                    .getResource("abusesWords/outString1.txt").toString().substring(5))));
            assertThat(scanner.nextLine(), is("Hello ! Just  it!"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenAbusesWordsExistsOneWordBestWithWhiteSpace() {
        try (InputStream in = new FileInputStream(getClass().getClassLoader()
                .getResource("abusesWords/inString2.txt").toString().substring(5))) {
            OutputStream out = new FileOutputStream(getClass().getClassLoader()
                    .getResource("abusesWords/outString2.txt").toString().substring(5));
            this.abusesWords.dropAbuses(in, out, new String[]{"best "});
            Scanner scanner = new Scanner(new File(getClass().getClassLoader()
                    .getResource("abusesWords/outString2.txt").toString().substring(5)));
            assertThat(scanner.nextLine(), is("today is the day"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
