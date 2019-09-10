package ru.job4j.lsp.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@ToString
public class Food {
    long id;
    final String name;
    final Date expiryDate;
    final Date createDate;
    final int price;
    int disscount;

    public Food(String name, Date expiryDate, Date createDate, int price) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
    }

    public void setDisscount(int disscount) {
        this.disscount = disscount;
    }

    public void setId(long id) {
        this.id = id;
    }

}
