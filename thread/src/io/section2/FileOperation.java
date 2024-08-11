package io.section2;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileOperation {
    public static void main(String[] args) {

        // Creates a fixed thread pool of size 5.
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Assume you are submitting 100 copy tasks,
        // then executor service uses a fixed thread
        // pool of size 5 to execute them.
        executor.execute(new Task("a.txt", "b.txt"));
        executor.execute(new Task("c.txt", "d.txt"));

        executor.close();
        System.out.println("Done...");
    }
}

class Task implements Runnable {

    String srcFile;
    String destFile;

    public Task(String srcFile, String destFile) {
        this.srcFile = srcFile;
        this.destFile = destFile;
    }

    @Override
    public void run() {
        try {
            IOUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
