package ru.my.model;

import lombok.*;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private Integer id;
    private String name;
}
