package io.section6_callable;

import java.util.concurrent.*;

class MyMath {
    public static int add(int x, int y) {
        return x + y;
    }
}

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int x = 10;
        int y = 20;

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return MyMath.add(x, y);
            }
        });

        while (!future.isDone())
            ; //wait
        int z = future.get();
        System.out.println("Result is :: " + z);
    }
}
