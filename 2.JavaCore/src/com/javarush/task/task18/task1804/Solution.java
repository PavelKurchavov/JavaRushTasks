package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream in = new FileInputStream(reader.readLine())) {

            Map<Integer, Integer> countBytes = new HashMap<>();

            while (in.available() > 0) {
                int read = in.read();

                if (countBytes.containsKey(read)) {
                    countBytes.put(read, countBytes.get(read) + 1);
                } else {
                    countBytes.put(read, 1);
                }
            }

            int minCount = Integer.MAX_VALUE;

            for (Map.Entry<Integer, Integer> entry: countBytes.entrySet()) {
                int count = entry.getValue();
                if (minCount > count) minCount = count;
            }

            for (Map.Entry<Integer, Integer> entry: countBytes.entrySet()) {
                if (entry.getValue() == minCount) System.out.print(entry.getKey() + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
