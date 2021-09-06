package com.javarush.task.pro.task15.task1506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        try(var reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> lines = Files.readAllLines(Paths.get(reader.readLine()));
            for (String line: lines) {
                String stringWithoutSomeSymbols = line.replaceAll("\\.", "").
                        replaceAll(",", "").replaceAll(" ", "");
                System.out.println(stringWithoutSomeSymbols);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

