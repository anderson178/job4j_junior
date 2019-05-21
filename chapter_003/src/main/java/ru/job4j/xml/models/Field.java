package ru.job4j.xml.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 05.06.2019
 */

@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Field {
    String value;
}
