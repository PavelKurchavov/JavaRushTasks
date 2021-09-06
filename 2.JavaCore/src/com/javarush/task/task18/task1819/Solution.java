package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = null;
        FileInputStream in1 = null;
        FileInputStream in2 = null;
        FileOutputStream out = null;

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = reader.readLine();
            String file2 = reader.readLine();

            in1 = new FileInputStream(file1);
            in2 = new FileInputStream(file2);
            out = new FileOutputStream(file1);

            byte[] buff1 = new byte[in1.available()];
            byte[] buff2 = new byte[in2.available()];

            if (in1.available() > 0) in1.read(buff1);
            if (in2.available() > 0) in2.read(buff2);

            out.write(buff2);
            out.write(buff1);



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) reader.close();
                if (in1 != null) in1.close();
                if (in2 != null) in2.close();
                if (out != null) out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
