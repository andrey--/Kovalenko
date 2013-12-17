package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FileTransactions {
    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }
    public static void delete(String fileName) throws FileNotFoundException {
        exists(fileName);
        new File(fileName).delete();
    }
    public static void write(String fileName, StringBuilder text) throws IOException  {
        File file = new File(fileName);
        try {
            if(!file.exists())
                file.createNewFile();
            else
                delete(fileName);

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new IOException(e);
        }
    }

}
