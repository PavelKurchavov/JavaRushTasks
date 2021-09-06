package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(console.readLine()))) {

            StringBuilder data = new StringBuilder();

            while (reader.ready()) {
                data.append(reader.readLine());
            }

            List<String> strs = new ArrayList<>(Arrays.asList(data.toString().split(" ")));


            List<Integer> numbers = strs.stream().map(str -> {
                try {
                    return Integer.parseInt(str);
                } catch (NumberFormatException e) {
                    double num = Double.parseDouble(str);
                    return (int) Math.round(num);
                }
            }).collect(Collectors.toList());

            for (Integer num : numbers) {
                writer.write(num + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
