package ru.job4j.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 02.07.2019
 */

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Vacancy {
    Integer id;
    String name;
    String description;
    String link;

    public Vacancy(String name, String description, String link) {
        this.name = name;
        this.description = description;
        this.link = link;
    }
}
