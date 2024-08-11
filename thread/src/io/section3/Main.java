package io.section3;

class CopyTask implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.print("C");
        }
    }
}

class ProgressTask implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.print("-");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new CopyTask());
        t1.setPriority(Thread.NORM_PRIORITY + 3);
        t1.start();

        Thread t2 = new Thread(new ProgressTask());
        t2.start();
    }
}
