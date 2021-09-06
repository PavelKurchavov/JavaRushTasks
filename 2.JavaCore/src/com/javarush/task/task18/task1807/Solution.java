package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream in = new FileInputStream(reader.readLine())) {

        int comma = ',';
        int commaCount = 0;

        while (in.available() > 0) {
            if (in.read() == comma) commaCount++;
        }

        System.out.println(commaCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
