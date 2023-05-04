package com.phucdevs.interview_1.queues;

public class Queue<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int count;

    // O(1)
    public void enqueue(T data) {

        this.count++;

        Node<T> oldLastNode = this.lastNode;
        this.lastNode = new Node<>(data);

        if (isEmpty()) {
            this.firstNode = this.lastNode;
        } else {
             oldLastNode.setNextNode(this.lastNode);
        }
    }

    // O(1)
    public T dequeue() {

        if (isEmpty()) return null;

        this.count--;

        T dataToRemove = this.firstNode.getData();
        this.firstNode = this.firstNode.getNextNode();

        if (isEmpty()) {
            this.lastNode = null;
        }

        return dataToRemove;
    }

    // O(1)
    public boolean isEmpty() {
        return this.firstNode == null;
    }

    // O(1)
    public int size() {
        return this.count;
    }
}
