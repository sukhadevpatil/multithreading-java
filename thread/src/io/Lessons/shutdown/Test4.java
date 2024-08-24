package io.Lessons.shutdown;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * shutdownNow() - This will interrupt all waiting threads & shutdown suddenly
 *
 */
public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.execute(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Task Thread Completed :: " + Thread.currentThread().getName());
        });
        executor.shutdownNow();

        System.out.println("Main Thread Completed :: " + Thread.currentThread().getName());
    }
}
