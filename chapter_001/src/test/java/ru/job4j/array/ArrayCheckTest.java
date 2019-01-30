package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayCheckTest {
    @Test
    public void whenStartWithPrefixThenTrue() {

        ArrayCheck word = new ArrayCheck();
        boolean result = word.checkWord("Hello", "Hi");
        assertThat(result, is(true));
    }
    @Test
    public void whenStartWithPrefixThenFalse() {
        ArrayCheck word = new ArrayCheck();
        boolean result = word.checkWord("Hello", "He");
        assertThat(result, is(true));
    }

}
