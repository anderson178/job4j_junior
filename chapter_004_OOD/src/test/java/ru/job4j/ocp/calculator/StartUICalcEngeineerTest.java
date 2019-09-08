package ru.job4j.ocp.calculator;

public class StartUICalcEngeineerTest {
//    private final PrintStream stdout = System.out;
//    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
//    private String ln = System.lineSeparator();
//    private MenuCalculator menu = new MenuEngineer();
//    private String menuShow = String.join("", "-----------MENU--------", ln, "0: Multiply", ln,
//            "1: Divide", ln, "2: Difference", ln, "3: Summ", ln, "4: Sin", ln, "5: Cos", ln, "6: Clear", ln, "7: Exit", ln,
//            "-----------------------", ln);
//
//    @Before
//    public void loadOutput() {
//        System.setOut(new PrintStream(this.out));
//    }
//
//    @After
//    public void backOutput() {
//        System.setOut(this.stdout);
//    }
//
//
//    @Test
//    public void whenUseSummTwoNumbers() {
//        Input input = new StabInput(new ArrayList<>(Arrays.asList("3", "4", "7", "7")));
//        StartUICalc startUICalc = new StartUICalc(input, this.menu);
//        startUICalc.execute();
//        assertThat(new String(out.toByteArray()),
//                Is.is(String.join("", this.menuShow, "11.0", ln, this.menuShow)));
//    }
//
//    @Test
//    public void whenUseMultipleTwoNumbers() {
//        Input input = new StabInput(new ArrayList<>(Arrays.asList("0", "4", "7", "7")));
//        StartUICalc startUICalc = new StartUICalc(input, this.menu);
//        startUICalc.execute();
//        assertThat(new String(out.toByteArray()),
//                Is.is(String.join("", this.menuShow, "28.0", ln, this.menuShow)));
//    }
//
//    @Test
//    public void whenUseDevideTwoNumbers() {
//        Input input = new StabInput(new ArrayList<>(Arrays.asList("1", "8", "4", "7")));
//        StartUICalc startUICalc = new StartUICalc(input, this.menu);
//        startUICalc.execute();
//        assertThat(new String(out.toByteArray()),
//                Is.is(String.join("", this.menuShow, "2.0", ln, this.menuShow)));
//    }
//
//    @Test
//    public void whenUseDifferenceTwoNumbers() {
//        Input input = new StabInput(new ArrayList<>(Arrays.asList("2", "8", "4", "7")));
//        StartUICalc startUICalc = new StartUICalc(input, this.menu);
//        startUICalc.execute();
//        assertThat(new String(out.toByteArray()),
//                Is.is(String.join("", this.menuShow, "4.0", ln, this.menuShow)));
//    }
//
//    @Test
//    public void whenUseSinTheNumber() {
//        Input input = new StabInput(new ArrayList<>(Arrays.asList("4", "80", "7")));
//        StartUICalc startUICalc = new StartUICalc(input, this.menu);
//        startUICalc.execute();
//        assertThat(new String(out.toByteArray()),
//                Is.is(String.join("", this.menuShow, "-0.9938886539233752", ln, this.menuShow)));
//    }
//
//    @Test
//    public void whenUseCosTheNumber() {
//        Input input = new StabInput(new ArrayList<>(Arrays.asList("5", "90", "7")));
//        StartUICalc startUICalc = new StartUICalc(input, this.menu);
//        startUICalc.execute();
//        assertThat(new String(out.toByteArray()),
//                Is.is(String.join("", this.menuShow, "-0.4480736161291701", ln, this.menuShow)));
//    }
//
//    @Test
//    public void whenUseExit() {
//        Input input = new StabInput(new ArrayList<>(Collections.singletonList("7")));
//        StartUICalc startUICalc = new StartUICalc(input, this.menu);
//        startUICalc.execute();
//        assertThat(new String(out.toByteArray()), Is.is(this.menuShow));
//    }
//
//    @Test
//    public void whenUseClean() {
//        Input input = new StabInput(new ArrayList<>(Arrays.asList("3", "8", "2", "6", "3", "10", "9", "7")));
//        StartUICalc startUICalc = new StartUICalc(input, this.menu);
//        startUICalc.execute();
//        assertThat(new String(out.toByteArray()), Is.is(String.join("", this.menuShow, "10.0",
//                ln, this.menuShow, this.menuShow, "19.0", ln, this.menuShow)));
//    }
//
//    @Test
//    public void whenUseSomeActions() {
//        Input input = new StabInput(new ArrayList<>(Arrays.asList("3", "8", "2", "3", "10", "7")));
//        StartUICalc startUICalc = new StartUICalc(input, this.menu);
//        startUICalc.execute();
//        assertThat(new String(out.toByteArray()), Is.is(String.join("", this.menuShow, "10.0", ln,
//                this.menuShow, "20.0", ln, this.menuShow)));
//    }
//
//    @Test(expected = ArrayIndexOutOfBoundsException.class)
//    public void whenExceptionOutOfMenuRnge() {
//        Input input = new StabInput(new ArrayList<>(Collections.singletonList("9")));
//        StartUICalc startUICalc = new StartUICalc(input, this.menu);
//        startUICalc.execute();
//    }
}
