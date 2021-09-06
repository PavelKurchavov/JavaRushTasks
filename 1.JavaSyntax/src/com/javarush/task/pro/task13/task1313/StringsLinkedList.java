package com.javarush.task.pro.task13.task1313;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();
    private Node newNode;

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        newNode = new Node();
        newNode.value = value;
        if (first.next == null && last.prev == null) {
            first.next = newNode;
            last.prev = newNode;
            return;
        }

        Node currentElement = first.next;
        while ((currentElement) != null) {
            Node next = currentElement.next;
            if (next == null) {
                currentElement.next = newNode;
                last.prev = newNode;
                newNode.prev = currentElement;
                return;
            }
            currentElement = currentElement.next;
        }
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
