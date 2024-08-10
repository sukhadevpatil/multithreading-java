package io.section2;

import java.io.*;

public class FileOperation {
    public static void main(String[] args) throws IOException {


        Thread t1 = new Thread(new Task("a.txt", "b.txt"));
        t1.start();

        Thread t2 = new Thread(new Task("c.txt", "d.txt"));
        t2.start();

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
