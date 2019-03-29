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
        try (InputStream in = new ByteArrayInputStream("23".getBytes())) {
            assertThat(bs.isNumber(in), is(false));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Test
    public void whenIsNumberTrue() {
        ByteStream bs = new ByteStream();
        try (InputStream in = new ByteArrayInputStream("374".getBytes())) {
            assertThat(bs.isNumber(in), is(true));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void whenExistSymbolsLineInStream() {
        ByteStream bs = new ByteStream();
        try (InputStream in = new ByteArrayInputStream("2asfdasde22".getBytes())) {
            assertThat(bs.isNumber(in), is(false));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
