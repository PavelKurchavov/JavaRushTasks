package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Collectors;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream in = new FileInputStream(reader.readLine())) {

            byte[] buff = new byte[in.available()];

            if (in.available() > 0) {
                in.read(buff);
            }

            Set<Byte> tempSet = new HashSet<>();

            for(Byte b: buff) {
                tempSet.add(b);
            }

            new ArrayList<>(tempSet).stream().sorted().forEach(x -> System.out.print( x + " "));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
