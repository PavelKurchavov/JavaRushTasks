package com.javarush.task.pro.task13.task1314;

public class StringsLinkedList {
    private final Node first = new Node();
    private final Node last = new Node();

    public void add(String value) {
        if (first.next == null) {
            Node node = new Node();
            node.value = value;
            first.next = node;
        }
        if (last.prev == null) {
            last.prev = first.next;
            return;
        }

        Node node = new Node();
        node.value = value;

        Node lastNode = last.prev;
        lastNode.next = node;
        node.prev = lastNode;
        last.prev = node;
    }

    public String get(int index) {
        Node result = null;

        Node currentNode = first.next;
        if (currentNode == null) return null;

        int currentIndex = 0;
        while (currentNode != null) {
            if (currentIndex == index) return currentNode.value;
            currentNode = currentNode.next;
            currentIndex++;
        }
        return null;
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
