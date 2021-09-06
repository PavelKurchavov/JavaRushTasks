package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    private static final SimpleDateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    private static final SimpleDateFormat resultFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {

        switch (args[0]) {
            case "-c": {
                create(args[1], args[2], args[3]);
                break;
            }
            case "-i": {
                info(args[1]);
                break;
            }
            case "-u": {
                update(args[1], args[2], args[3], args[4]);
                break;
            }
            case "-d": {
                delete(args[1]);
                break;
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
            Sex sexa = sex.equals("м") ? Sex.MALE : Sex.FEMALE;
            Date birthDate = sourceFormat.parse(bd);

            Person person = allPeople.get(intId);
            person.setName(name);
            person.setSex(sexa);
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
