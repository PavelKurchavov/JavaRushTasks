package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(0d, "defr");
        labels.put(1d, "dgrefr");
        labels.put(2d, "defrgr");
        labels.put(3d, "defrh");
        labels.put(4d, "defrj");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
