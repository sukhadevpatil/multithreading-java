package io.Lessons.shutdown;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executor after shutdown will not allow any new Task to submit, will throw an exception as its already shutdown
 * But the task's before shutdown will allow to complete
 */
public class Test1 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.submit(() -> System.out.println("Task 1 Thread ..."));

        executor.shutdown();

        //After thread pool service shutdown, no new thready would accept, hence would throw an exception
        executor.submit(() -> System.out.println("Task 2 Thread ..."));
    }
}
