package ru.job4j.task;

import java.util.*;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 12.03.2019
 */


public class Analize {
    private Info info = new Info();

    /**
     * Метод определяет разницу между первым и вторым листом.
     * Весь метод основывается на простом алгоритме метода исключений, когда убираем варианты которые не могут
     * подвергаться исходному условия. В кадом подметоде каждый раз мы укорачиваем листы если это удовлетворяет
     * условию, а остатки фиксируем в счетчиках info.
     * Hashset для info.added необходимо что бы избавитьс от дубликатов
     *
     * @param previous - лист с изначальным состояние
     * @param current  - лист с текущим состоянием
     * @return - объект info содержащий подсчитанную разницу листов
     */
    public Info diff(List<User> previous, List<User> current) {
        List<User> tempPrev = this.infoDeleted(previous, current);
        List<User> tempCurt = this.infoChanged(tempPrev, current);
        info.added = new HashSet<>(tempCurt).size();
        return info;
    }

    /**
     * Метод подсчета изменных объектов.
     * Работает за счет того, что удаляет из временного листа совпадающие одинаковыые объекты и объекты поле name
     * которых не совпадает (последнее фиксируется в счетчике изменений) с листом текущего состоения
     *
     * @param tempPrev - пересозданный лист из листа начального состояния.
     * @param current  - лист с текущим состоянием
     * @return - оставшиеся элементы из врменнего листа содержавший лист с текущим состоянием
     */
    private List<User> infoChanged(List<User> tempPrev, List<User> current) {
        List<User> tempCurt = new ArrayList<>(current);
        for (User userP : tempPrev) {
            for (int i = 0; i < tempCurt.size(); i++) {
                if (userP.getId().equals(tempCurt.get(i).getId()) && userP.getName().equals(tempCurt.get(i).getName())) {
                    tempCurt.remove(i--);
                } else if (userP.getId().equals(tempCurt.get(i).getId()) && !userP.getName().equals(tempCurt.get(i).getName())) {
                    tempCurt.remove(i--);
                    info.cnanged++;
                }
            }
        }
        return tempCurt;
    }

    /**
     * Метод подсчета удаленных объектов.
     * Работает за счет, того что удаляет из временного листа содержавший исходное состояние объекты которые отсуствуют
     * в листе с текущим состоянием.
     *
     * @param previous - лист с изначальным состояние
     * @param current  - лист с текущим состоянием
     * @return - лист с оставшимися элеиз временного листа содержавший лист с исходным состоянием
     */
    private List<User> infoDeleted(List<User> previous, List<User> current) {
        boolean check = false;
        List<User> tempPrev = new ArrayList<>(previous);
        for (int i = 0; i < tempPrev.size(); i++) {
            for (User userC : current) {
                if (tempPrev.get(i).getId().equals(userC.getId())) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                tempPrev.remove(i--);
                this.info.deleted++;
            }
            check = false;
        }
        return tempPrev;
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
