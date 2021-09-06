package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {
        try(FileInputStream in = new FileInputStream(args[0])) {

            String contentWithSpaces;
            String contentWithoutSpaces;
            byte[] buff = new byte[in.available()];

            if (in.available() > 0) {
                in.read(buff);
            }

            contentWithSpaces = new String(buff);
            contentWithoutSpaces = contentWithSpaces.replaceAll(" ", "");

            System.out.printf("%.2f", ((double) contentWithSpaces.length() - contentWithoutSpaces.length())/contentWithSpaces.length() * 100);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
