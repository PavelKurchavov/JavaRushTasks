package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileOutputStream out = new FileOutputStream(reader.readLine(), true);
             FileInputStream in2 = new FileInputStream(reader.readLine());
             FileInputStream in3 = new FileInputStream(reader.readLine()))
        {

            byte[] buff2 = new byte[in2.available()];
            byte[] buff3 = new byte[in3.available()];

            if (in2.available() > 0) in2.read(buff2);
            if (in3.available() > 0) in3.read(buff3);

            out.write(buff2);
            out.write(buff3);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
