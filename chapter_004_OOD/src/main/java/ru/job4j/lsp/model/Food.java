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
    final int createDate;
    final int price;
    int disscount;

    public Food(String name, String expaireDate, int createDate, int price) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
    }

    public void setDisscount(int disscount) {
        this.disscount = disscount;
    }

    public void setId(String id) {
        this.id = id;
    }

}
