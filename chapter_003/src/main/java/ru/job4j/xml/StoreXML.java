package ru.job4j.xml;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.xml.models.Field;
import ru.job4j.xml.models.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
public class StoreXML {
    final File target;
    public static final Logger LOG = LoggerFactory.getLogger(StoreSQL.class.getName());

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
        } catch (JAXBException e) {
            LOG.error(e.getMessage(), e);
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
