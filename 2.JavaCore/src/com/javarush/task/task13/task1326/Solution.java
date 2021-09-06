package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream in = new FileInputStream(reader.readLine())) {

            byte[] buff = new byte[in.available()];

            while (in.available() > 0) {
                in.read(buff);
            }
            String s = new String(buff).replaceAll("[^-\\d]", " ").replaceAll(" {2}", " ");
            Arrays.stream(s.split(" "))
                    .map(Integer::parseInt)
                    .filter(x -> x % 2== 0)
                    .sorted()
                    .collect(Collectors.toList())
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
