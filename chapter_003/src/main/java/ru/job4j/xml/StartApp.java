package ru.job4j.xml;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 05.06.2019
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StartApp {
    static final Logger LOG = LoggerFactory.getLogger(StoreSQL.class.getName());
    static final String SR = File.separator;
    static final String ROOT_PATH = System.getProperty("java.io.tmpdir") + SR + "chapter_003_SQL";
    static final String XML_PATH = ROOT_PATH + SR + "target.xml";
    static final String XSL_PATH = ROOT_PATH + SR + "targetConvert.xsl";
    ParsingXSL parsingXSL;
    StoreSQL storeSQL;


    /**
     * Метод запускает поочердности каждый из методов
     *
     * @param size - количество элементов которые будут храниться в БД
     */
    public void init(Integer size) {
        this.processDB(size);
        this.generatedXML();
        this.convertXSQT();
        this.pars();
    }

    /**
     * Метод запускает парсер файла типа xsl
     */
    private void pars() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(false);
        SAXParser parser;
        InputStream xmlData = null;
        parsingXSL = new ParsingXSL();
        try {
            xmlData = new FileInputStream(XSL_PATH);
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
    }

    /**
     * Метод подготоваливает БД для ее дальнейшей работы записав значения в таблицу
     *
     * @param size - количество элементов в таблице
     */
    private void processDB(Integer size) {
        this.storeSQL = new StoreSQL(new Config());
        this.storeSQL.init();
        this.storeSQL.generate(size);
    }

    /**
     * Метод генерирует создает xml файл на основе данных взятых из таблицы
     */
    private void generatedXML() {
        File root = new File(ROOT_PATH);
        StoreXML.clearDir(root.getAbsolutePath());
        root.mkdir();
        StoreXML storeXML = new StoreXML(new File(XML_PATH));
        storeXML.save(storeSQL.getAllValues());
    }

    /**
     * Метод конвертирует файл типа xml в файл типа xsl
     */
    private void convertXSQT() {
        new ConvertXSQT().convert(new File(XML_PATH), new File(XSL_PATH));
    }

    /**
     * Метод возвращает сумму всех значений поля name
     *
     * @return
     */
    public Integer getSumm() {
        return parsingXSL.getSum();
    }

    public static void main(String[] args) {
        StartApp startApp = new StartApp();
        startApp.init(10);
        System.out.println(startApp.getSumm());
    }
}
