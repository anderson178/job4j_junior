package ru.job4j.io.chat.archive;

import java.io.File;

public class ParsLine {
    private String[] args;

    public ParsLine(String[] args) {
        this.args = args;
    }

    public String getExecude() {
        String execude = null;
        for (int i = 0; i < args.length - 1; i = i + 2) {
            if (args[i].equals("-e")) {
                execude = args[i + 1].split("\\.")[1];
                break;
            }
        }
        return execude;
    }

    public String getPathDirectoy() {
        String pathDirectory = null;
        for (int i = 0; i < args.length - 1; i = i + 2) {
            if (args[i].equals("-d")) {
                pathDirectory = new File(args[i + 1]).getAbsolutePath();
                break;
            }
        }
        return pathDirectory;
    }

    public String getNameOutFile() {
        String nameOutFile = null;
        for (int i = 0; i < args.length - 1; i = i + 2) {
            if (args[i].equals("-o")) {
                nameOutFile = args[i + 1];
                break;
            }
        }
        return nameOutFile;
    }
}
