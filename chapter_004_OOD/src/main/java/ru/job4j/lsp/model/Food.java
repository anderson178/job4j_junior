package ru.job4j.lsp.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@ToString
@EqualsAndHashCode
public class Food {
    String id;
    final String name;
    final String expaireDate;
    final String createDate;
    final int price;
    final String disscount;

    public Food(String name, String expaireDate, String createDate, int price, String disscount) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
        this.disscount = disscount;
    }

    public void setId(String id) {
        this.id = id;
    }
}
