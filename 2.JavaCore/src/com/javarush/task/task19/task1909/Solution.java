package com.javarush.task.task19.task1909;

import java.io.*;

/*
Замена знаков
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            String inFile = console.readLine();
            String outFile = console.readLine();
            StringBuilder sb = new StringBuilder();
            String result;

            try (BufferedReader in = new BufferedReader(new FileReader(inFile))) {
                while (in.ready()) sb.append((char) in.read());
                result = sb.toString().replaceAll("\\.", "!");
            }

            try(BufferedWriter out = new BufferedWriter(new FileWriter(outFile))) {
                out.write(result);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

