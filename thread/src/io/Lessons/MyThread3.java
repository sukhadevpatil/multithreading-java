package io.Lessons;

import java.util.List;

public class MyThread3 extends Thread {

    private String tName;

    public MyThread3(String tName) {
        this.tName = tName;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println(tName + "Hello World!...");
        }
    }

    public static void main(String[] args) {
        MyThread3 t1 = new MyThread3("Thread T1 - ");
        t1.setDaemon(true); // Daemon thread will active till main thread is active
        t1.start();

        System.out.println("Main end");
        List.of(1,2,3,4,5).forEach(System.out::println);

//        MyThread3 t2 = new MyThread3("Thread T2 - ");
//        t2.start();
    }
}
