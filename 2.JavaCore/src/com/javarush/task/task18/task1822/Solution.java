package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader file = new BufferedReader(new FileReader(console.readLine()))) {

            while (file.ready()) {
                String[] data = file.readLine().split(" ");
                if (data[0].equals(args[0])) {
                    Arrays.stream(data).forEach(x -> System.out.print(x + " "));
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
