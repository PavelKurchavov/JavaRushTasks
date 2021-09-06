package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName;
            while (!(fileName = reader.readLine()).equals("exit")) {
                new ReadThread(fileName).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class ReadThread extends Thread {
        private final String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try (FileInputStream in = new FileInputStream(fileName)) {

                byte[] bytes = new byte[in.available()];

                if (in.available() > 0) {
                    in.read(bytes);
                }

                Map<Byte, Integer> countOfBytes = new HashMap<>();

                for (Byte b : bytes) {
                    countOfBytes.merge(b, 1, Integer::sum);
                }

                Byte maxCountsByte = Collections.max(countOfBytes.entrySet(),
                        Comparator.comparingInt(Map.Entry::getValue)).getKey();

                resultMap.put(fileName, (int) maxCountsByte);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
