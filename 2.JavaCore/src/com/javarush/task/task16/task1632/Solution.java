package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread(() -> {
            while (true) {}
        }));

        threads.add(new Thread(() -> {
            try {
                throw new InterruptedException();
            } catch (InterruptedException i) {
                System.out.println("InterruptedException");
            }
        }));

        threads.add(new Thread(() -> {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));

        class FourThread extends Thread implements Message {
            boolean isInterrupt = false;
            @Override
            public void showWarning() {
                isInterrupt = true;
            }

            @Override
            public void run() {
                while (!isInterrupt) {

                }
            }
        }

        threads.add(new FourThread());

        class FirthThread implements Runnable {

            @Override
            public void run() {
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String line;
                double sum = 0;
                while (!(line = reader.readLine()).equals("N")) {
                    sum += Double.parseDouble(line);
                }
                System.out.println(sum);

            } catch (IOException e) {
                e.printStackTrace();
            }
            }
        }

        threads.add(new Thread(new FirthThread()));
    }

    public static void main(String[] args) {
        threads.forEach(Thread::start);
    }
}