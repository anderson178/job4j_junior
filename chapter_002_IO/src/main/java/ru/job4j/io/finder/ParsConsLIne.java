package ru.job4j.io.finder;

public class ParsConsLIne {
    private String[] args;
    private String dest;
    private String nameFile;
    private String flag;
    private String log;


    public ParsConsLIne(String[] args) {
        this.args = args;
        this.dest = setPathDestenation();
        this.nameFile = setName();
        this.log = setPathLog();
        this.flag = setFlag();
    }


   /* private boolean checkKey(int indexK, String expected) {
        boolean str = false;
        if (args[indexK].equals("-d")) {
            destenation = args[1];
        } else {
            System.out.println("Введен некорреткный ключ");
        }
    }*/

    private String setPathDestenation() {
        String destenation = null;
        if (args[0].equals("-d")) {
            destenation = args[1];
        } else {
            System.out.println("Введен некорреткный ключ");
        }
        return destenation;
    }

    public String getPathDestenation() {
        return this.dest;
    }

    private String setName() {
        String name = null;
        if (args[2].equals("-n")) {
            name = args[3];
        } else {
            System.out.println("Введен некорреткный ключ");
        }
        return name;
    }

    public String getName() {
        return this.nameFile;
    }

    private String setFlag() {
        String flag = null;
        if (args[4].equals("-m") || args[4].equals("-f") || args[4].equals("-r")) {
            flag = args[4];
        } else {
            System.out.println("Введен некорреткный ключ");
        }
        return flag;
    }

    public String getFlag() {
        return this.flag;
    }

    private String setPathLog() {
        String output = null;
        if (args[5].equals("-o")) {
            output = args[6];
        } else {
            System.out.println("Введен некорреткный ключ");
        }
        return output;
    }

    public String getPathLog() {
        return this.log;
    }


}
