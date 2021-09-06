package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             InputStream input = new FileInputStream(reader.readLine())) {
            byte[] buff = new byte[input.available()];
            while (input.available() > 0) {
                input.read(buff);
            }
            System.out.println(new String(buff));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}