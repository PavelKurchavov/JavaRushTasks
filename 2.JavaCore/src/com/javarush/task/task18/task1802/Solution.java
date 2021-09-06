package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream in = new FileInputStream(reader.readLine())) {

            int min = 10000;

            while (in.available() > 0) {
                int read = in.read();
                if (min > read) min = read;
            }

            System.out.println(min);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
