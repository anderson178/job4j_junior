package ru.job4j.xml.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 05.06.2019
 */

@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    List<Field> values;
}


