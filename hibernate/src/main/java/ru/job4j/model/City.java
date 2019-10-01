package ru.job4j.model;

import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "City")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

//    @OneToMany(mappedBy = "city")
//    private Set<Employee> employees = new HashSet<>();

}
