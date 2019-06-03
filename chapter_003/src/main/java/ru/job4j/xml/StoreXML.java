package ru.job4j.xml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.job4j.xml.models.Field;
import ru.job4j.xml.models.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
public class StoreXML {
    final File target;
    static final String SR = File.separator;


    public void save(List<Field> list) {
        this.checkFile();
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(User.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(
                    new User(list),
                    target
            );
            int p=0;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void checkFile() {
        if (this.target.exists()) {
            target.delete();
            try {
                target.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                target.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Config config = new Config();
        config.init();
        StoreSQL storeSQL = new StoreSQL(config);
        storeSQL.init();
        storeSQL.generate(100);
        String pathFiles = System.getProperty("java.io.tmpdir") + SR + "target";
        StoreXML storeXML = new StoreXML(new File(pathFiles));
        storeXML.save(storeSQL.getAllValues());

    }


}
