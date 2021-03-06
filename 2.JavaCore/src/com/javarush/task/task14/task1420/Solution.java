package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());

        if (a < 1 || b < 1) throw new IllegalArgumentException();

        int nod = 1;

        for (int i = 1; i <= (Math.min(a, b)); i++) {
            if (a % i == 0 && b % i == 0) nod = i;
        }

        System.out.println(nod);

    }
}
