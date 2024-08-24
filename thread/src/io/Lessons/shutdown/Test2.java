package io.Lessons.shutdown;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Main thread completes before Task thread, but still it allows to complete its task before getting shutdown
 */
public class Test2 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.submit( () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Thread.currentThread().setName("MyTask-Thread");
            System.out.println("Task execution completed..." + Thread.currentThread().getName());
        });

        System.out.println("Main Thread Completed :: " + Thread.currentThread().getName());
    }
}
