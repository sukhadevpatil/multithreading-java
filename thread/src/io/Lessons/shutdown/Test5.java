package io.Lessons.shutdown;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Scheduled job will trigger after delay of 2 seconds & executes only once
 * Capture future object
 */
public class Test5 {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        Future<String> future = executorService.schedule(() ->
        {
            Thread.sleep(5000);
            return "Hello";
        }, 2, TimeUnit.SECONDS);
        executorService.shutdown();
        try {
            System.out.println(future.get());
        } catch (Exception exc) {
            System.out.println("Exception :: " + exc.getCause());
        }

        System.out.println("Main completed...");
    }
}
