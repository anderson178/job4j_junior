package ru.job4j.task;

import java.util.*;

public class Analize {
    private boolean check = false;

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        List<User> temp = new ArrayList<>(current);
        List<User> temp2 = new ArrayList<>(current);

        List<User> tempPrev = new ArrayList<>(previous);
        List<User> tempCurt = new ArrayList<>(current);

        for (int i = 0; i < tempPrev.size(); i++) {
            this.check = false;
            for(User userC : tempCurt) {
                if (tempPrev.get(i).getId().equals(userC.getId())) {
                    this.check = true;
                    break;
                }
            }
            if (!this.check) {
                tempPrev.remove(i--);
                info.deleted++;
            }
        }


            for (User userP : previous) {
                temp = new ArrayList<>(temp2);
                for (User userC : temp) {
                    if (userP.getId().equals(userC.getId()) && userP.getName().equals(userC.getName())) {
                        temp2.remove(userC);
                    }
                    if (userP.getId().equals(userC.getId()) && !userP.getName().equals(userC.getName())) {
                        temp2.remove(userC);
                        info.cnanged++;
                    }
                }
            }
        info.added = temp2.size();
        int p = 0;


        return info;
    }

    /*private void different(List<User> first, List<User> second, Info info) {
        for (User userS : second) {
            for (User userF : first) {
                if(userS.getId().equals(userF.getId()) && userS.getName().equals(userF.getName())) {
                    this.check = true;
                    break;
                }
            }
            if (!this.check) {
                info.;
            }
            this.check = false;
        }
    }*/


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
    }
}
