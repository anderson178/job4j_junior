package ru.job4j;

public class ForMe {

    private static class Sinc implements Runnable{
        private final String name;
        public Sinc(String name) {
            this.name = name;
        }



        @Override
        public void run() {
            //try {
                //Thread.sleep(30000);
                System.out.println("I' am " + this.name);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }
    }

    public static void main(String[] args) {
        System.out.println("1");
        new Thread(new Sinc("Ivan")).start();
        new Thread(new Sinc("Denis")).start();
        System.out.println("2");

    }
}
