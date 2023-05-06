package com.phucdevs.interview_1.hashtables;

// key-value pair we eant to store in the HashTable
public class HashItem {

    private int key;
    private int value;
    // in case of a collision use a Linked List
    private HashItem nextItem;

    public HashItem(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public HashItem getNextItem() {
        return nextItem;
    }

    public void setNextItem(HashItem nextItem) {
        this.nextItem = nextItem;
    }
}
