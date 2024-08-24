package io.Lessons.shutdown;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Scheduled job will trigger after initial delay of 2 seconds & after period of 3 seconds frequency
 * The new thread will not execute the previous get complete
 */
public class Test7 {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        Future<?> future = executorService.scheduleAtFixedRate(() -> {
            System.out.println("Scheduled Task started...");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Scheduled Task ended...");
        }, 2, 3, TimeUnit.SECONDS);

        try {
            Thread.sleep(10000);
            //future.cancel(true);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main completed...");
    }
}
