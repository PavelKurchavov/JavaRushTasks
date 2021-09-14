package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            try (BufferedReader in = new BufferedReader(new FileReader(reader.readLine()));
                 BufferedWriter out = new BufferedWriter(new FileWriter(reader.readLine()))) {
                int i = 1;
                while (in.ready()) {
                    int c = in.read();
                    if (i % 2 == 0) {
                        out.write(c);
                    }
                    i++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
