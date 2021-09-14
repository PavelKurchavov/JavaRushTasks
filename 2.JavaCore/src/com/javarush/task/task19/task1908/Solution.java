package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) {

        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            String inFile = console.readLine();
            String outFile = console.readLine();
            StringBuilder sb = new StringBuilder();

            try (BufferedReader in = new BufferedReader(new FileReader(inFile))) {
                while (in.ready()) sb.append((char) in.read());
            }

            try(BufferedWriter out = new BufferedWriter(new FileWriter(outFile))) {
                for (String word: sb.toString().split(" ")) {
                    try {
                        Integer.parseInt(word);
                        out.write(word);
                        out.write(" ");
                    } catch (NumberFormatException ignored) {
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
