package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayCheckTest {
    @Test
    public void whenStartWithPrefixThenTrue() {

        ArrayCheck word = new ArrayCheck();
        boolean result = word.checkWord("Hello", "Hi");
        int p =0;
        assertThat(result, is(false));
    }
    @Test
    public void whenStartWithPrefixThenFalse() {
        ArrayCheck word = new ArrayCheck();
        boolean result = word.checkWord("Hello", "He");
        assertThat(result, is(true));
    }

}
