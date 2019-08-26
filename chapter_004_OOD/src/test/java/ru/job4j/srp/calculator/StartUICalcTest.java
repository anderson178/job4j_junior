package ru.job4j.srp.calculator;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.StartUICalc;
import ru.job4j.srp.ordinaryCalc.Input;
import ru.job4j.srp.ordinaryCalc.MenuCalculator;
import ru.job4j.srp.ordinaryCalc.StabInput;
import ru.job4j.srp.ordinaryCalc.action.Difference;
import ru.job4j.srp.ordinaryCalc.action.Divide;
import ru.job4j.srp.ordinaryCalc.action.Multiply;
import ru.job4j.srp.ordinaryCalc.action.Summ;

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
    private MenuCalculator menu = new MenuCalculator();
    private String menuShow = String.join("", "-----------MENU--------", ln, "0: Multiply", ln,
            "1: Divide", ln, "2: Difference", ln, "3: Summ", ln, "4: Clear", ln, "5: Exit", ln,
            "-----------------------", ln);

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    @Before
    public void fillMenu() {
        this.menu.addAction(new Multiply(this.menu.getSize(), Multiply.class.getSimpleName()));
        this.menu.addAction(new Divide(menu.getSize(), Divide.class.getSimpleName()));
        this.menu.addAction(new Difference(this.menu.getSize(), Difference.class.getSimpleName()));
        this.menu.addAction(new Summ(this.menu.getSize(), Summ.class.getSimpleName()));

    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }


    @Test
    public void whenUseSummTwoNumbers() {
        Input input = new StabInput(new ArrayList<>(Arrays.asList("3", "4", "7", "5")));
        StartUICalc startUICalc = new StartUICalc(input, this.menu);
        startUICalc.execute();
        assertThat(new String(out.toByteArray()),
                Is.is(String.join("", this.menuShow, "11.0", ln, this.menuShow)));
    }

    @Test
    public void whenUseMultipleTwoNumbers() {
        Input input = new StabInput(new ArrayList<>(Arrays.asList("0", "4", "7", "5")));
        StartUICalc startUICalc = new StartUICalc(input, this.menu);
        startUICalc.execute();
        assertThat(new String(out.toByteArray()),
                Is.is(String.join("", this.menuShow, "28.0", ln, this.menuShow)));
    }

    @Test
    public void whenUseDevideTwoNumbers() {
        Input input = new StabInput(new ArrayList<>(Arrays.asList("1", "8", "4", "5")));
        StartUICalc startUICalc = new StartUICalc(input, this.menu);
        startUICalc.execute();
        assertThat(new String(out.toByteArray()),
                Is.is(String.join("", this.menuShow, "2.0", ln, this.menuShow)));
    }

    @Test
    public void whenUseDifferenceTwoNumbers() {
        Input input = new StabInput(new ArrayList<>(Arrays.asList("2", "8", "4", "5")));
        StartUICalc startUICalc = new StartUICalc(input, this.menu);
        startUICalc.execute();
        assertThat(new String(out.toByteArray()),
                Is.is(String.join("", this.menuShow, "4.0", ln, this.menuShow)));
    }

    @Test
    public void whenUseExit() {
        Input input = new StabInput(new ArrayList<>(Collections.singletonList("5")));
        StartUICalc startUICalc = new StartUICalc(input, this.menu);
        startUICalc.execute();
        assertThat(new String(out.toByteArray()), Is.is(this.menuShow));
    }

    @Test
    public void whenUseClean() {
        Input input = new StabInput(new ArrayList<>(Arrays.asList("3", "8", "2", "4", "3", "10", "9", "5")));
        StartUICalc startUICalc = new StartUICalc(input, this.menu);
        startUICalc.execute();
        assertThat(new String(out.toByteArray()), Is.is(String.join("", this.menuShow, "10.0",
                ln, this.menuShow, this.menuShow, "19.0", ln, this.menuShow)));
    }

    @Test
    public void whenUseSomeActions() {
        Input input = new StabInput(new ArrayList<>(Arrays.asList("3", "8", "2", "3", "10", "5")));
        StartUICalc startUICalc = new StartUICalc(input, this.menu);
        startUICalc.execute();
        assertThat(new String(out.toByteArray()), Is.is(String.join("", this.menuShow, "10.0", ln,
                this.menuShow, "20.0", ln, this.menuShow)));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenExceptionOutOfMenuRnge() {
        Input input = new StabInput(new ArrayList<>(Collections.singletonList("9")));
        StartUICalc startUICalc = new StartUICalc(input, this.menu);
        startUICalc.execute();
    }


}
