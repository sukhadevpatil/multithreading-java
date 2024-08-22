package io.Lessons;

public class Lesson1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread :: " + Thread.currentThread().getState());

        Runnable runnable = () -> {
            System.out.println("  Hi there !!  ");
        };

        Thread thread = new Thread(runnable);
        System.out.println("After thread creation :: " + thread.getState());
        thread.start();
        System.out.println("After thread start :: " + thread.getState());

        thread.join();
        System.out.println("After join :: " + thread.getState());
    }
}
