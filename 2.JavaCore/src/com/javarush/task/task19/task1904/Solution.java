package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        PersonScanner ps = new PersonScannerAdapter(new Scanner(new File("C:\\Users\\Family\\Desktop\\file.txt")));
        System.out.println(ps.read());
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.fileScanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            if (!fileScanner.hasNext()) {
                return null;
            }
            String line = fileScanner.nextLine();
            System.out.println(line);
            String[] data = line.split(" ");
            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            Date birthday = null;
            String formattedDate = String.format("%s-%s-%s", data[3], data[4], data[5]);
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            try {
                birthday = format.parse(formattedDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Person(firstName, middleName, lastName, birthday);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
