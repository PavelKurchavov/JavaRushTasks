package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Пидор Жопный", 123.9);
        grades.put("Пидор rgr", 123.29);
        grades.put("Пидор rgrg", 1233.9);
        grades.put("Пидор qwewq", 1213.9);
        grades.put("Пидор Жопdvный", 1253.9);
    }
}
