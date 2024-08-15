package io.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        int minPoolSize = 2;
        int maxPoolSize = 4;
        int queueSize = 3;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(minPoolSize, maxPoolSize,
                1, TimeUnit.HOURS, new ArrayBlockingQueue<>(queueSize));
    }
}
