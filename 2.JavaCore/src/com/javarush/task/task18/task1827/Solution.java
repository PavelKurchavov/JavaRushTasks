package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = "";

        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true))) {
            out.write(Product.getProductFromArgs(args, fileName).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class Product {
    int id;
    String productName;
    double price;
    int quantity;

    Product(int id, String productName, double price, int quantity) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return formatString(String.valueOf(id), 8)
                + formatString(productName, 30)
                + formatString(String.valueOf(price), 8)
                + formatString(String.valueOf(quantity), 4) + "\n";
    }

    private String formatString(String line, int countSymbols) {
        return (line.length() >= countSymbols)
                ? line.substring(0, countSymbols)
                : String.format("%-" + countSymbols + "s", line);
    }

    public static Product getProductFromArgs(String[] args, String fileName) {
        List<String> list = new ArrayList<>(Arrays.asList(args));
        list.remove(0);
        int id = getMaxId(fileName) + 1;
        double price = Double.parseDouble(list.remove(list.size() - 2));
        int quantity = Integer.parseInt(list.remove(list.size() - 1));
        StringBuilder productName = new StringBuilder();

        for (String arg : list) {
            productName.append(arg);
            productName.append(" ");
        }
        return new Product(id, productName.toString().trim(), price, quantity);
    }

    private static int getMaxId(String fileName) {
        int maxIndex = 0;
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            while (in.ready()) {
                String productStr = in.readLine();
                int id = Integer.parseInt(productStr.substring(0, 8).trim());
                if (id > maxIndex) {
                    maxIndex = id;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maxIndex;
    }
}
