package Practicks;

public class TestThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("дочерний поток или побочный поток ");
            }
        });
        thread.start();
        System.out.println("Главный поток main");
    }
}
