package com.javarush.task.task18.task1801;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Paths;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream in = new FileInputStream(reader.readLine())) {
            int max = 0;

            while (in.available() > 0) {
                int read = in.read();
                if (max < read) max = read;
            }
            System.out.println(max);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
