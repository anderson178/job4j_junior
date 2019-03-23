package ru.job4j.io;

import org.junit.Test;

import java.io.*;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 24.03.2019
 */

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ByteStreamTest {

    @Test
    public void whenIsNumberFalse() {
        ByteStream bs = new ByteStream();
        try (InputStream in = new ByteArrayInputStream(new FileInputStream(
                "C://projects//job4j_junior//chapter_002_IO//src//main//resources//byteFiles//67.txt")
                .readAllBytes())) {
            assertThat(bs.isNumber(in), is(false));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void whenIsNumberTrue() {
        ByteStream bs = new ByteStream();
        try (InputStream in = new ByteArrayInputStream(new FileInputStream(
                "C://projects//job4j_junior//chapter_002_IO//src//main//resources//byteFiles//10.txt")
                .readAllBytes())) {
            assertThat(bs.isNumber(in), is(true));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
