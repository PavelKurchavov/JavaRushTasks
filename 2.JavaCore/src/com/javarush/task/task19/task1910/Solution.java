package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
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
                String result = sb.toString().replaceAll("\\p{P}", "").replaceAll("\n","");
                out.write(result);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
