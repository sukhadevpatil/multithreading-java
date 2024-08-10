package io;

import java.io.*;

public class IOUtils {

    public static void copy(InputStream is, OutputStream os) throws IOException {
        int val = 0;

        while ((val = is.read()) != -1) {
            os.write(val);
        }
    }

    public static void copyFile(String sourceFile, String destFile) throws IOException {
        if(!new File(sourceFile).exists()) new File(sourceFile).createNewFile();
        if(!new File(destFile).exists()) new File(destFile).createNewFile();

        FileInputStream fin = new FileInputStream(sourceFile);
        FileOutputStream fout = new FileOutputStream(destFile);

        IOUtils.copy(fin, fout);

        System.out.println("File data copied...");
        fin.close();
        fout.close();
    }
}
