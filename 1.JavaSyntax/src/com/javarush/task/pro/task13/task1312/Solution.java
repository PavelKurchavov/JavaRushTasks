package com.javarush.task.pro.task13.task1312;

import java.util.ArrayList;
import java.util.HashMap;

/* 
ArrayList vs HashMap
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getProgrammingLanguages());
    }

    public static HashMap<Integer, String> getProgrammingLanguages() {
        HashMap<Integer, String> langMap = new HashMap<>();
        ArrayList<String> programmingLanguagesList = new ArrayList<>();
        programmingLanguagesList.add("Java");
        programmingLanguagesList.add("Kotlin");
        programmingLanguagesList.add("Go");
        programmingLanguagesList.add("Javascript");
        programmingLanguagesList.add("Typescript");
        programmingLanguagesList.add("Python");
        programmingLanguagesList.add("PHP");
        programmingLanguagesList.add("C++");

        for (int i = 0; i < programmingLanguagesList.size(); i++) {
            langMap.put(i, programmingLanguagesList.get(i));
        }
        return langMap;
    }

}
