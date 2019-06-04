package ru.job4j.xml;

import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

public class StartUI {
    public static void main(String[] args) throws IOException, TransformerException {
         String SR = File.separator;
        //формируем конфиг
        Config config = new Config();
        config.init();

        //генерируем данные в таблице
        StoreSQL storeSQL = new StoreSQL(config);
        storeSQL.init();
        storeSQL.generate(10);

        //конвертируем данные из тиблицы в xml
        File root = new File(System.getProperty("java.io.tmpdir") + SR + "chapter_003_SQL");
        StoreXML.clearDir(root.getAbsolutePath());
        root.mkdir();
        File xml = new File(root  + SR +"target.xml");
        StoreXML storeXML = new StoreXML(xml);
        storeXML.save(storeSQL.getAllValues());
        ConvertXSQT convertXSQT = new ConvertXSQT();
        convertXSQT.convert(xml, xml);
        convertXSQT.toStringXML(xml);

    }
}
