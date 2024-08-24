package io.Lessons.shutdown;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * awaitTermination() - This will keep hold for provided time before proceeding
 * In following snippet its awaiting 2 seconds then proceeds
 */
public class Test3 {
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
        executor.shutdown();
        boolean isTerminated = executor.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("Is Task Terminated :: " + isTerminated);
        System.out.println("Main Thread Completed :: " + Thread.currentThread().getName());
    }
}
