package com.javarush.task.pro.task15.task1504;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             InputStream input = Files.newInputStream(Paths.get(scanner.nextLine()));
             OutputStream output = Files.newOutputStream(Paths.get(scanner.nextLine()))) {

            byte[] bytesIn = input.readAllBytes();
            byte[] bytesOut = new byte[bytesIn.length];

            for(int i = 0; i < bytesIn.length; i+= 2) {
                byte first = bytesIn[i];
                if (i == bytesIn.length - 1) {
                    bytesOut[i] = first;
                    break;
                }
                byte second = bytesIn[i + 1];
                bytesOut[i] = second;
                bytesOut[i + 1] = first;
            }

            output.write(bytesOut);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

