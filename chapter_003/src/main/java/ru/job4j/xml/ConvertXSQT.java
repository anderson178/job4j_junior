package ru.job4j.xml;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConvertXSQT {
    private static final String LS = System.lineSeparator();

    public void convert(File source, File dest) throws IOException, TransformerException {
    String xml = this.toStringXML(source);
        String xsl = "<?xml version=\"1.0\"?>\n" +
                "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\n" +
                "<xsl:template match=\"/\">\n" +
                "<entries>" +
                "   <xsl:for-each select=\"user/values\">\n" +
                "       <entry>" +
                "           <xsl:attribute name=\"href\">" +
                "               <xsl:value-of select=\"value\"/>" +
                "           </xsl:attribute>" +
                "       </entry>\n" +
                "   </xsl:for-each>\n" +
                " </entries>\n" +
                "</xsl:template>\n" +
                "</xsl:stylesheet>\n";
        //System.out.println(xsl);

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
        transformer.transform(new StreamSource(
                new ByteArrayInputStream(xml.getBytes())),
                new StreamResult(System.out));

    }

    public String toStringXML(File source) throws IOException {
        StringBuffer rst = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(source.getPath()))) {

            String tt = br.readLine();
            //rst = br.toString();

            br.lines().forEach(line -> rst.append(line + LS));
        }
        //System.out.println(rst.toString());
        return rst.toString();

    }
}
