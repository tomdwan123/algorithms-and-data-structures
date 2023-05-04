package com.phucdevs.interview_1.doublylinkedlist;

public class App {

    public static void main(String[] args) {

        DoublyLinkedList<String> names = new DoublyLinkedList<>();
        names.insert("Adam");
        names.insert("Kevin");
        names.insert("Ana");
        names.insert("Daniel");

        names.traverseForward();
        names.traverseBackward();
    }
}
