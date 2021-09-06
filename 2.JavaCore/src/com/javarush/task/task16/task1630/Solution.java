package com.javarush.task.task16.task1630;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            firstFileName = reader.readLine();
            secondFileName = reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface  {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileName;
        private String content = "";

        @Override
        public void setFileName(String fullFileName) {
            this.fileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return content;
        }

        @Override
        public void run() {
            try(InputStream in = Files.newInputStream(Paths.get(fileName))) {

                byte[] buff = new byte[in.available()];
                if (in.available() > 0) {
                    in.read(buff);
                }
                content = new String(buff).replaceAll("[\\n\\t\\r\\f]", " ").replaceAll(" {2}", " ");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
