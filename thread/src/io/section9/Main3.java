package io.section9;

class Sample3 {

    static int a = 5;
    int b = 10;

    // This method is static and hence it locks the Class object.
    public static synchronized void incrementA( ) {
        a++;
    }

    // This method is non static and hence it locks the object
    // on which it is invoked.
    public synchronized void increment( ) {
        incrementA();
        b++;
    }
}

class MyThread3 extends Thread {

    Sample3 obj;

    public MyThread3(Sample3 obj) {
        this.obj = obj;
    }

    public void run() {
        obj.increment();
    }

}

public class Main3 {

    public static void main(String[] args) {

        Sample3 obj = new Sample3();

        // In this case both the threads t1 and t2
        // are sharing the same Sample object obj.
        // Both the threads will try to perform the
        // increment operation simultaneously.

        MyThread3 t1 = new MyThread3(obj);
        MyThread3 t2 = new MyThread3(obj);

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

