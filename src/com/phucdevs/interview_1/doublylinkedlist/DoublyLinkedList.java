package com.phucdevs.interview_1.doublylinkedlist;

public class DoublyLinkedList<T extends Comparable<T>> {

    private Node<T> head;
    private Node<T> tail;

    public void insert(T data) {

        Node<T> newNode = new Node<>(data);

        // this is the first item in the doubly linked list
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            // we will insert new node to the ending of the doubly linked list
            newNode.setPreviousNode(tail);
            tail.setNextNode(newNode);
            tail = newNode;
        }
    }

    public void traverseForward() {

        Node<T> actualNode = head;
        while (actualNode != null) {
            System.out.println(actualNode);
            actualNode = actualNode.getNextNode();
        }
    }

    public void traverseBackward() {

        Node<T> actualNode = tail;
        while (actualNode != null) {
            System.out.println(actualNode);
            actualNode = actualNode.getPreviousNode();
        }
    }
}
