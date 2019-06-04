package ru.job4j.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

public class StartApp {
    public static void main(String[] args) {
        Logger LOG = LoggerFactory.getLogger(StoreSQL.class.getName());
        String SR = File.separator;
        //формируем конфиг
        Config config = new Config();
        config.init();

        //генерируем данные в таблице
        StoreSQL storeSQL = new StoreSQL(config);
        storeSQL.init();
        storeSQL.generate(1000000);

        //конвертируем данные из тиблицы в xml
        File root = new File(System.getProperty("java.io.tmpdir") + SR + "chapter_003_SQL");
        StoreXML.clearDir(root.getAbsolutePath());
        root.mkdir();
        File xml = new File(root + SR + "target.xml");
        StoreXML storeXML = new StoreXML(xml);
        storeXML.save(storeSQL.getAllValues());
        ConvertXSQT convertXSQT = new ConvertXSQT();
        File xsl = new File(root + SR + "targetConvert.xsl");
        convertXSQT.convert(xml, xsl);


        SAXParserFactory factory = SAXParserFactory.newInstance();

        factory.setValidating(true);
        factory.setNamespaceAware(false);
        SAXParser parser;

        InputStream xmlData = null;
        ParsingXSL parsingXSL = new ParsingXSL();
        try {
            xmlData = new FileInputStream(xsl.getPath());
            parser = factory.newSAXParser();
            parser.parse(xmlData, parsingXSL);
        } catch (FileNotFoundException e) {
            LOG.error(e.getMessage(), e);
        } catch (ParserConfigurationException e) {
            LOG.error(e.getMessage(), e);
        } catch (SAXException e) {
            LOG.error(e.getMessage(), e);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }

        System.out.println(parsingXSL.getSum());

    }
}
