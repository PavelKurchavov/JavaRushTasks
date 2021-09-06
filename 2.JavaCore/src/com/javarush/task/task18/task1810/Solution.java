package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                FileInputStream in = new FileInputStream(reader.readLine());
                if (in.available() < 1000) {
                    in.close();
                    throw new DownloadException();
                }
                in.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class DownloadException extends Exception {

    }
}
