package com.javarush.task.pro.task16.task1616;

import com.sun.source.tree.Tree;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/* 
Тренировка временных зон
*/

public class Solution {

    public static void main(String[] args) {
        TreeSet<String> sortedZones = getSortedZones();
        System.out.println(sortedZones.size());
        System.out.println(sortedZones.first());
        System.out.println(sortedZones.last());

        System.out.println(getBeijingTime());
    }

    static TreeSet<String> getSortedZones() {
        Set<String> zones = ZoneId.getAvailableZoneIds();
        return new TreeSet<>(zones);
    }

    static ZonedDateTime getBeijingTime() {
        return ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
    }
}
