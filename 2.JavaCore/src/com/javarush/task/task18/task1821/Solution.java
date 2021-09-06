package com.javarush.task.task18.task1821;



import java.io.*;
import java.util.*;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) {
        try(FileInputStream in = new FileInputStream(args[0])) {
            Map<Character, Integer> countOfChars = new HashMap<>();
            byte[] data = new byte[in.available()];

            if (in.available() > 0) {
                in.read(data);
            }

            for (Character c : new String(data).toCharArray()) {
                countOfChars.merge(c, 1, Integer::sum);
            }

            List<Character> chars = new ArrayList<>(countOfChars.keySet());
            Collections.sort(chars);

            chars.forEach(c -> System.out.println(c + " " + countOfChars.get(c)));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
