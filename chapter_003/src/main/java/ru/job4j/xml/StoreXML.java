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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
public class StoreXML {
    final File target;

    public void save(List<Field> list) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(User.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(
                    new User(list),
                    System.out
            );
            int p=0;
        } catch (JAXBException e) {
            e.printStackTrace();
        }



    }

    public static void main(String[] args) {
        Config config = new Config();
        config.init();
        StoreSQL storeSQL = new StoreSQL(config);
        storeSQL.init();
        storeSQL.generate(100);
        StoreXML storeXML = new StoreXML(new File("sdsd"));
        storeXML.save(storeSQL.getAllValues());

    }


}
