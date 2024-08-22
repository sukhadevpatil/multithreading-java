package io.Lessons;

public class MyThread2 extends Thread {

    public MyThread2(String name) {
        super(name);
    }

    @Override
    public void run() {

        String val = "";
        for(int i = 0; i <= 1000; i++) {
            val += String.valueOf(i);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Priority " + Thread.currentThread().getPriority());
            Thread.yield();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        MyThread2 l = new MyThread2("t1");
        l.setPriority(Thread.MIN_PRIORITY);

        MyThread2 m = new MyThread2("t2");
        m.setPriority(Thread.NORM_PRIORITY);

        MyThread2 h = new MyThread2("t3");
        h.setPriority(Thread.MAX_PRIORITY);

        l.start();
        m.start();
        h.start();



    }
}
