package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<>();

    private static final SimpleDateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    private static final SimpleDateFormat resultFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        switch (args[0]) {
            case "-c": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        create(args[i], args[i + 1], args[i + 2]);
                    }
                    break;
                }
            }
            case "-u": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        update(args[i], args[i + 1], args[i + 2], args[i + 3]);
                    }
                    break;
                }
            }
            case "-d": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        delete(args[i]);
                    }
                    break;
                }
            }
            case "-i": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        info(args[i]);
                    }
                    break;
                }
            }

        }
    }

    public static void create(String name, String sex, String bd) {
        try {
            Date birthDate = sourceFormat.parse(bd);
            if (sex.equals("м")) allPeople.add(Person.createMale(name, birthDate));
            else if (sex.equals("ж")) allPeople.add(Person.createFemale(name, birthDate));
            System.out.println(allPeople.size() - 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public static void info(String id) {
        int intId = Integer.parseInt(id);

        Person person = allPeople.get(intId);
        String name = person.getName();
        String sex = person.getSex().equals(Sex.MALE) ? "м" : "ж";
        String bd = resultFormat.format(person.getBirthDate());

        System.out.println(name + " " + sex + " " + bd);
    }


    public static void update(String id, String name, String sex, String bd) {
        try {
            int intId = Integer.parseInt(id);
            Sex sexB = sex.equals("м") ? Sex.MALE : Sex.FEMALE;
            Date birthDate = sourceFormat.parse(bd);

            Person person = allPeople.get(intId);
            person.setName(name);
            person.setSex(sexB);
            person.setBirthDate(birthDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void delete(String id) {
        int intId = Integer.parseInt(id);
        Person person = allPeople.get(intId);
        person.setName(null);
        person.setSex(null);
        person.setBirthDate(null);
    }
}
