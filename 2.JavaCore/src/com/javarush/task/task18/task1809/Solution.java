package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream in1 = new FileInputStream(reader.readLine());
            FileOutputStream out2 = new FileOutputStream(reader.readLine())) {

            byte[] buff = new byte[in1.available()];
            if (in1.available() > 0) {
                in1.read(buff);
            }

            List<Byte> list = new ArrayList<>();

            for (Byte a: buff) {
                list.add(a);
            }

            Collections.reverse(list);

            byte[] out = new byte[list.size()];

            for(int i = 0; i < list.size(); i++) {
                out[i] = list.get(i);
            }

            out2.write(out);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
