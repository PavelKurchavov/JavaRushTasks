package com.javarush.task.pro.task15.task1507;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        for (int i = 0; i < lines.size(); i++) {
            if (i % 2 != 0) continue;
            System.out.println(lines.get(i));
        }

    }
}

