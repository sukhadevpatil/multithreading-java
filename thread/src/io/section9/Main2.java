package io.section9;

class Sample1 {

    static int a = 5;
    int b = 10;

    public  void increment( ) {
        // lock the Class object before modifying
        // static content.
        synchronized(Sample.class) {
            a++;
        }

        // lock the object before modifying
        // instance members.
        synchronized(this) {
            b++;
        }
    }
}

class MyThread1 extends Thread {

    Sample1 obj;

    public MyThread1(Sample1 obj) {
        this.obj = obj;
    }

    public void run() {
        obj.increment();
    }

}

public class Main2 {

    public static void main(String[] args) {

        Sample1 obj = new Sample1();

        // In this case both the threads t1 and t2
        // are sharing the same Sample object obj.
        // Both the threads will try to perform the
        // increment operation simultaneously.

        MyThread1 t1 = new MyThread1(obj);
        MyThread1 t2 = new MyThread1(obj);

        t1.start();
        t2.start();

        // Here main thread called the join operation
        // on t1 and t2. join() operations waits for
        // thread to complete before returning.
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(obj.a);
        System.out.println(obj.b);

    }

}
