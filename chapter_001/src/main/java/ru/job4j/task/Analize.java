package ru.job4j.task;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 17.03.2019
 */


public class Analize {

    /**
     * Метод загружает в карту данные из нового листа и проходя через старый список удаляет из карты
     *
     * @param previous - лист с изначальным состояние
     * @param current  - лист с текущим состоянием
     * @return - объект info содержащий подсчитанную разницу листов
     */
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        HashMap<Integer, String> map = new HashMap<>();
        current.forEach(user -> map.put(user.id, user.name));
        for (User user : previous) {
            if (!map.containsKey(user.id)) {
                info.deleted++;
            } else if (!map.remove(user.id).equals(user.name)) {
                info.cnanged++;
            }
        }
        info.added = map.size();
        return info;
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Info {
        private int added;
        private int cnanged;
        private int deleted;

        public int getAdded() {
            return added;
        }

        public int getCnanged() {
            return cnanged;
        }

        public int getDeleted() {
            return deleted;
        }
    }
}
