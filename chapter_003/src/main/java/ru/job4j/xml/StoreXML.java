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
import java.util.LinkedList;
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
                    target
            );
            int p=0;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void clearDir(String pathDirectoy) {
        LinkedList<File> directorys = new LinkedList<>();
        directorys.offer(new File(pathDirectoy));
        while (!directorys.isEmpty()) {
            File file = directorys.poll();
            File[] dir = file.listFiles();
            if (file.isDirectory() && dir.length != 0) {
                for (File directory : dir) {
                    directorys.offer(directory);
                }
            } else {
                file.delete();
            }
        }
    }




}
