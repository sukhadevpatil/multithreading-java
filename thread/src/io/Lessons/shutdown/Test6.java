package io.Lessons.shutdown;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Scheduled job will trigger after initial delay of 2 seconds & after period of 5 seconds frequency
 */
public class Test6 {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        executorService.scheduleAtFixedRate(() -> System.out.println("Hello"), 2, 5, TimeUnit.SECONDS);

        System.out.println("Main completed...");
    }
}
