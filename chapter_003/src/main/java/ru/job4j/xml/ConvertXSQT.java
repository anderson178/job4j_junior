package ru.job4j.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 05.06.2019
 */

public class ConvertXSQT {
    private static final String LS = System.lineSeparator();
    public static final Logger LOG = LoggerFactory.getLogger(StoreSQL.class.getName());

    /**
     * Метод ковенвертирует файл типа xml в файл типа xsl
     *
     * @param source - xml
     * @param dest   - xsl
     */

    public void convert(File source, File dest) {
        String xml = this.toStringXML(source);
        String xsl = "<?xml version=\"1.0\"?>\n"
                + "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\n"
                + "<xsl:template match=\"/\">\n"
                + "<values>"
                + "   <xsl:for-each select=\"user/values\">\n"
                + "       <value>"
                + "           <xsl:attribute name=\"href\">"
                + "               <xsl:value-of select=\"value\"/>"
                + "           </xsl:attribute>"
                + "       </value>\n"
                + "   </xsl:for-each>\n"
                + " </values>\n"
                + "</xsl:template>\n"
                + "</xsl:stylesheet>\n";
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = factory.newTransformer(
                    new StreamSource(
                            new ByteArrayInputStream(xsl.getBytes()))
            );
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        try {
            transformer.transform(new StreamSource(
                            new ByteArrayInputStream(xml.getBytes())),
                    new StreamResult(dest));
        } catch (TransformerException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Метод считывает данные из файла типа xml и записывает в строку
     *
     * @param source
     * @return
     */
    public String toStringXML(File source) {
        StringBuffer rst = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(source.getPath()))) {
            br.lines().forEach(line -> rst.append(line + LS));
        } catch (FileNotFoundException e) {
            LOG.error(e.getMessage(), e);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return rst.toString();
    }
}
