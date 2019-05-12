package ru.job4j.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 12.04.2019
 */

public class AnalysisLogTest {
    private static final String SR = File.separator;
    private static final String LS = System.lineSeparator();
    private static final String PATHDIR = System.getProperty("java.io.tmpdir") + "chapter_002_IO";
    private static final String LOG = "log.txt";
    private static final String TARGET = "unavailable.txt";

    /*@Test
    public void whenTwoIntervals() throws IOException {
        AnalysisLog analysisLog = new AnalysisLog();
        analysisLog.removeDir(PATHDIR);
        analysisLog.createFile(PATHDIR, LOG);
        analysisLog.createFile(PATHDIR, TARGET);
        analysisLog.writeFile("200 10:56:01" + LS + "500 10:57:01" + LS + "400 10:58:01" + LS + "200 10:59:01"
                + LS + "500 11:01:02" + LS + "200 11:02:02", PATHDIR + SR + LOG);
        analysisLog.unavailable(PATHDIR + SR + LOG, PATHDIR + SR + TARGET);
        List<String> expected = new ArrayList<>(Arrays.asList("10:57:01:10:59:01", "11:01:02:11:02:02"));
        assertThat(analysisLog.readFile(PATHDIR + SR + TARGET), is(expected));
    }

    @Test
    public void whenThreeIntervals() throws IOException {
        AnalysisLog analysisLog = new AnalysisLog();
        analysisLog.removeDir(PATHDIR);
        analysisLog.createFile(PATHDIR, LOG);
        analysisLog.createFile(PATHDIR, TARGET);
        analysisLog.writeFile("200 10:56:01" + LS + "500 10:57:01" + LS + "400 10:58:01" + LS + "200 10:59:01"
                + LS + "500 11:01:02" + LS + "200 11:02:02" + LS + "200 11:03:05" + LS + "500 11:04:15" + LS
                + "200 11:05:01", PATHDIR + SR + LOG);
        analysisLog.unavailable(PATHDIR + SR + LOG, PATHDIR + SR + TARGET);
        List<String> expected = new ArrayList<>(Arrays.asList("10:57:01:10:59:01",
                "11:01:02:11:02:02",
                "11:04:15:11:05:01"));
        assertThat(analysisLog.readFile(PATHDIR + SR + TARGET), is(expected));

    }


    @Test
    public void whenThreeIntervalsOptionNumberTwo() throws IOException {
        AnalysisLog analysisLog = new AnalysisLog();
        analysisLog.removeDir(PATHDIR);
        analysisLog.createFile(PATHDIR, LOG);
        analysisLog.createFile(PATHDIR, TARGET);
        analysisLog.writeFile("400 10:56:01" + LS + "500 10:57:01" + LS + "400 10:58:01" + LS + "200 10:59:01"
                + LS + "500 11:01:02" + LS + "200 11:02:02" + LS + "200 11:03:05" + LS + "500 11:04:15" + LS
                + "200 11:05:01", PATHDIR + SR + LOG);
        analysisLog.unavailable(PATHDIR + SR + LOG, PATHDIR + SR + TARGET);
        List<String> expected = new ArrayList<>(Arrays.asList("10:56:01:10:59:01",
                "11:01:02:11:02:02",
                "11:04:15:11:05:01"));
        assertThat(analysisLog.readFile(PATHDIR + SR + TARGET), is(expected));
    }

    @Test
    public void whenLogLastShutDown() throws IOException {
        AnalysisLog analysisLog = new AnalysisLog();
        analysisLog.removeDir(PATHDIR);
        analysisLog.createFile(PATHDIR, LOG);
        analysisLog.createFile(PATHDIR, TARGET);
        analysisLog.writeFile("200 10:56:01" + LS + "500 10:57:01" + LS + "400 10:58:01" + LS + "200 10:59:01"
                + LS + "500 11:01:02", PATHDIR + SR + LOG);
        analysisLog.unavailable(PATHDIR + SR + LOG, PATHDIR + SR + TARGET);
        List<String> expected = new ArrayList<>(Arrays.asList("10:57:01:10:59:01", "11:01:02:11:01:02"));
        assertThat(analysisLog.readFile(PATHDIR + SR + TARGET), is(expected));
    }*/

}
