package ru.job4j.lsp.storage;

import java.util.Date;

public class Calculate {
    public static int calculatePercent(Date createDate, Date expiryDate) {
        int periodDays = (int) ((expiryDate.getTime() - createDate.getTime()) / (24 * 60 * 60 * 1000));
        int daysPassed = (int) ((new Date(System.currentTimeMillis()).getTime() - createDate.getTime()) / (24 * 60 * 60 * 1000));
        return (int) ((double) daysPassed / periodDays * 100);
    }
}
