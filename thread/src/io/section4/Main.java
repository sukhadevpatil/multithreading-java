package io.section4;

class MyTask implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


public class Main {
    public static void main(String[] args) {

        // CREATING A THREADGROUP
        ThreadGroup tGrp = new ThreadGroup("MyGroup");
        tGrp.setMaxPriority(7);

        // ASSOCIATING A THREAD WITH THREAD GROUP
        Thread th = new Thread(tGrp, new MyTask(), "MyTask Thread");
        th.start();

        System.out.println("Listing threads hierarchy...");

        Thread t = Thread.currentThread();
        ThreadGroup threadGroup = t.getThreadGroup();

        while (threadGroup.getParent() != null) {
            threadGroup = threadGroup.getParent();
        }
        threadGroup.list();
    }
}
