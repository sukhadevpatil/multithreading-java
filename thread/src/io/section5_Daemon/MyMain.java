package io.section5_Daemon;

public class MyMain {

    public static void main(String[] args) {
        Thread thr = Thread.currentThread();
        ThreadGroup grp = thr.getThreadGroup();
        while (grp.getParent() != null) {
            grp = grp.getParent();
        }

        Thread [] threads = new Thread[10];
        int n = grp.enumerate(threads);

        for (int i=0; i < n; i++) {
            System.out.println(
                    "Thread Name: " + threads[i].getName() +
                            " ; isDaemon: " + threads[i].isDaemon());
        }
    }
}
