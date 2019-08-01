package ru.job4j.srp.calculator;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 14.08.2019
 */
public class StartUICalcTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private String ln = System.lineSeparator();
    private String menu = String.join("", "-----------MENU--------", ln, "0: Multiple", ln,
            "1: Devide", ln, "2: Difference", ln, "3: Summ", ln, "4: Clear", ln, "5: Exit", ln,
            "-----------------------", ln);

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }


    @Test
    public void whenUseSummTwoNumbers() {
        Input input = new StabInput(new ArrayList<>(Arrays.asList("3", "4", "7", "5")));
        StartUICalc startUICalc = new StartUICalc(input, new MenuCalculator());
        startUICalc.execute();
        assertThat(new String(out.toByteArray()),
                Is.is(String.join("", this.menu, "11.0", ln, this.menu)));
    }

    @Test
    public void whenUseMultipleTwoNumbers() {
        Input input = new StabInput(new ArrayList<>(Arrays.asList("0", "4", "7", "5")));
        StartUICalc startUICalc = new StartUICalc(input, new MenuCalculator());
        startUICalc.execute();
        assertThat(new String(out.toByteArray()),
                Is.is(String.join("", this.menu, "28.0", ln, this.menu)));
    }

    @Test
    public void whenUseDevideTwoNumbers() {
        Input input = new StabInput(new ArrayList<>(Arrays.asList("1", "8", "4", "5")));
        StartUICalc startUICalc = new StartUICalc(input, new MenuCalculator());
        startUICalc.execute();
        assertThat(new String(out.toByteArray()),
                Is.is(String.join("", this.menu, "2.0", ln, this.menu)));
    }

    @Test
    public void whenUseDifferenceTwoNumbers() {
        Input input = new StabInput(new ArrayList<>(Arrays.asList("2", "8", "4", "5")));
        StartUICalc startUICalc = new StartUICalc(input, new MenuCalculator());
        startUICalc.execute();
        assertThat(new String(out.toByteArray()),
                Is.is(String.join("", this.menu, "4.0", ln, this.menu)));
    }

    @Test
    public void whenUseExit() {
        Input input = new StabInput(new ArrayList<>(Collections.singletonList("5")));
        StartUICalc startUICalc = new StartUICalc(input, new MenuCalculator());
        startUICalc.execute();
        assertThat(new String(out.toByteArray()), Is.is(this.menu));
    }

    @Test
    public void whenUseClean() {
        Input input = new StabInput(new ArrayList<>(Arrays.asList("3", "8", "2", "4", "3", "10", "9", "5")));
        StartUICalc startUICalc = new StartUICalc(input, new MenuCalculator());
        startUICalc.execute();
        assertThat(new String(out.toByteArray()), Is.is(String.join("", this.menu, "10.0",
                ln, this.menu, this.menu, "19.0", ln, this.menu)));
    }

    @Test
    public void whenUseSomeActions() {
        Input input = new StabInput(new ArrayList<>(Arrays.asList("3", "8", "2", "3", "10", "5")));
        StartUICalc startUICalc = new StartUICalc(input, new MenuCalculator());
        startUICalc.execute();
        assertThat(new String(out.toByteArray()), Is.is(String.join("", this.menu, "10.0", ln,
                this.menu, "20.0", ln, this.menu)));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenExceptionOutOfMenuRnge() {
        Input input = new StabInput(new ArrayList<>(Collections.singletonList("9")));
        StartUICalc startUICalc = new StartUICalc(input, new MenuCalculator());
        startUICalc.execute();
    }


}
