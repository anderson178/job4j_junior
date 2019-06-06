package ru.job4j.xml;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 05.06.2019
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParsingXSL extends DefaultHandler {
    int sum;

    /**
     * Метод проходит заданный тег и проверяет на наличие заданного тега суммируя значения всех тегов
     *
     * @param uri        - пространство имен
     * @param localName  - локальное имя элемента
     * @param qName      - комбинация локального имени с пространством имен
     * @param attributes - атрибуты элемента
     */
    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) {
        if (qName.equals("value")) {
            sum += Integer.parseInt(attributes.getValue("href"));
        }
        try {
            super.startElement(uri, localName, qName, attributes);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public Integer getSum() {
        return sum;
    }

}
