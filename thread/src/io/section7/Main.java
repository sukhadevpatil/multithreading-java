package io.section7;

import java.io.File;
import java.util.List;

/**
 * Here we are not using threads, instead we are searching each file in sequential order.
 */
public class Main {

    public static void main(String[] args) {

        // pattern to search
        String pattern = "Transfer";

        // Directory or folder to search
        File dir = new File("./sample");

        // list all the files present in the folder.
        File [] files = dir.listFiles();

        PatternFinder finder = new PatternFinder();

        long startTime = System.currentTimeMillis();

        // for each file in the list of files

        for (File file : files) {

            List<Integer> lineNumbers = finder.find(file, pattern);

            if (! lineNumbers.isEmpty()) {
                System.out.println(
                        pattern + "; found at " + lineNumbers +
                                " in the file - " + file.getName());
            }

        }

        System.out.println(
                " Time taken for search - " + (System.currentTimeMillis() - startTime));

    }
}
