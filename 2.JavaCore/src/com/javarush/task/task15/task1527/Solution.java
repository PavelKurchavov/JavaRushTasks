package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String[] params = reader.readLine().split("\\?")[1].split("&");
            Object objValue = null;
            StringBuilder nameParams = new StringBuilder();

            for (String param : params) {
                if (param.contains("=")) {
                    String[] keyAndValue = param.split("=");
                    String key = keyAndValue[0];
                    nameParams.append(key).append(" ");
                    if (key.equals("obj")) {
                        objValue = keyAndValue[1];
                    }
                } else nameParams.append(param).append(" ");
            }

            System.out.println(nameParams.toString().trim());

            if (objValue != null) {
                try {
                    alert(Double.parseDouble(String.valueOf(objValue)));
                } catch (NumberFormatException e) {
                    alert(String.valueOf(objValue));
                }
            }

        } catch(IOException e){
                e.printStackTrace();
            }
        }



    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
