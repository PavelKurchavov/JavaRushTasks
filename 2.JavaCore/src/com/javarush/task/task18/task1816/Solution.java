package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
        try(FileInputStream in = new FileInputStream(args[0])) {
            String content;
            byte[] buff = new byte[in.available()];
            if (in.available() > 0) {
                in.read(buff);
            }

            content = new String(buff);

            content = content.replaceAll("[^a-zA-Z]","");
            System.out.println(content.length());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
