package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        System.out.println(hen.getCountOfEggsPerMonth());
        System.out.println(hen.getDescription());
        Hen hen2 = HenFactory.getHen(Country.MOLDOVA);
        System.out.println(hen2.getDescription());

    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            switch (country) {
                case Country.RUSSIA:
                    hen = new RussianHen();
                    break;
                case Country.UKRAINE:
                    hen = new UkrainianHen();
                    break;
                case Country.BELARUS:
                    hen = new BelarusianHen();
                    break;
                case Country.MOLDOVA:
                    hen = new MoldovanHen();
                    break;
            }
            return hen;
        }
    }


}
