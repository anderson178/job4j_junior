package ru.job4j.task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Analize {
    private boolean check = false;

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        for (User userC : current) {
            for (User userP : previous) {
                if(userC.getId().equals(userP.getId()) && userC.getName().equals(userP.getName())) {
                    this.check = true;
                    break;
                }
            }
            if (!this.check) {
                info.setAdded(userC);

            }
            this.check = false;


        }

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
        private List<User> added = new ArrayList<>();
        private List<User> changed;
        private List<User> deleted;

        public void setAdded(User user) {
            this.added.add(user);
        }

        public void setChanged(User user) {
            this.changed.add(user);
        }

        public void setADleted(User user) {
            this.deleted.add(user);
        }

        public List<User> getAdded() {
            return added;
        }
    }
}
