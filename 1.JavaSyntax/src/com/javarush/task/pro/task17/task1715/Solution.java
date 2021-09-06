package com.javarush.task.pro.task17.task1715;

import java.util.ArrayList;
import java.util.List;

/* 
Вилларибо и Виллабаджо.
*/

public class Solution {
    static List<MusicalInstrument> orchestra = new ArrayList<>();

    public static void main(String[] args) {
        createKeyboardOrchestra();
        createStringedOrchestra();
        playOrchestra();
    }

    public static void createKeyboardOrchestra() {
        orchestra.add(new Piano());
        orchestra.add(new Piano());
        orchestra.add(new Piano());
        orchestra.add(new Organ());
    }

    public static void createStringedOrchestra() {
        orchestra.add(new Guitar());
        orchestra.add(new Violin());
        orchestra.add(new Violin());
    }

    public static void playOrchestra() {
        orchestra.forEach(MusicalInstrument::play);
    }
}
