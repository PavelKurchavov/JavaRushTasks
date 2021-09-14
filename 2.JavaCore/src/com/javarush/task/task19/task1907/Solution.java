package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = console.readLine();
            List<Character> chars = new ArrayList<>();

            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
                while (fileReader.ready()) chars.add((char) fileReader.read());
            }

            StringBuilder str = new StringBuilder();
            chars.forEach(str::append);
            String[] result = str.toString().split("[^a-zA-Z0-9]");
            long count = Arrays.stream(result).filter(c -> c.equalsIgnoreCase("world")).count();
            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
