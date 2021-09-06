package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine(), true))) {

            String line;
            do {
               line = reader.readLine();
               writer.write(line + "\n");
            }
            while(!line.equals("exit"));

        } catch(IOException e) {
               e.printStackTrace();
        }
    }
}
