package ru.job4j.srp.calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.srp.ordinaryCalc.StabInput;
import ru.job4j.srp.ordinaryCalc.ValidateInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 14.08.2019
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;
    private String ln = System.lineSeparator();

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ArrayList<Integer> range = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            range.add(i);
        }
        ArrayList<String> answerList = new ArrayList<>(Arrays.asList("invalid", "0"));
        ValidateInput input = new ValidateInput(new StabInput(answerList));
        input.ask("Select: ", range);
        assertThat(this.mem.toString(), is("Please enter validate data again" + this.ln));
    }

}
