package ru.job4j.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParsingXSL extends DefaultHandler {
    private int sum;

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        if (qName.equals("value")) {
            sum += Integer.parseInt(attributes.getValue("href"));
        }
        super.startElement(uri, localName, qName, attributes);
    }

    public Integer getSum() {
        return sum;
    }

}
