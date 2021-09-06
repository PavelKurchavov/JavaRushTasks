package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader1 = new BufferedReader(new FileReader(reader.readLine()));
             BufferedReader fileReader2 = new BufferedReader(new FileReader(reader.readLine()))) {

            while (fileReader1.ready()) {
                allLines.add(fileReader1.readLine());
            }

            while (fileReader2.ready()) {
                forRemoveLines.add(fileReader2.readLine());
            }

            new Solution().joinData();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
