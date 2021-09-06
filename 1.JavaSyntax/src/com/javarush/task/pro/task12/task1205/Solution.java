package com.javarush.task.pro.task12.task1205;

/* 
Метод деления
*/

public class Solution {

    public static void main(String[] args) {
        divide(1, 0);
        divide(-1, 0);
        divide(0, 0);
        divide(100, 20);
        divide(200, 20);
    }

    public static void divide(double a, double b) {
        double posInf = Double.POSITIVE_INFINITY;
        double negInf = Double.NEGATIVE_INFINITY;
        if((a > 0 && b == 0) || (a == posInf && b >= 0 && b != posInf) || (a == negInf &&  b < 0 && b != negInf)) {
            System.out.println(posInf);
        }
        else if((a < 0 && b == 0) || (a == negInf && b >= 0 && b != posInf) || (a == posInf && b < 0 && b != negInf)) {
            System.out.println(negInf);
        }
        else if((a == 0 && b == 0) || (a == posInf && b == posInf) || (a == posInf && b == negInf) || (a == negInf && b == posInf) || (a == negInf && b == negInf)) {
            System.out.println(Double.NaN);
        }
        else System.out.println(a/b);
    }
}
