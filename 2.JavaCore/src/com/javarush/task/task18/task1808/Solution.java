package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream in = new FileInputStream(reader.readLine());
            FileOutputStream out1 = new FileOutputStream(reader.readLine());
            FileOutputStream out2 = new FileOutputStream(reader.readLine()))
        {

            byte[] buff = new byte[in.available()];

            if (in.available() > 0) {
                in.read(buff);
            }

            int separationIndex = (buff.length % 2 == 0) ? (buff.length / 2) : (int) (Math.floor(buff.length / 2d + 1 ));

            out1.write(buff, 0, separationIndex);
            out2.write(buff, separationIndex, buff.length - separationIndex);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
