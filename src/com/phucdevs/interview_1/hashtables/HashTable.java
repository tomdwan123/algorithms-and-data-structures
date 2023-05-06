package com.phucdevs.interview_1.hashtables;

public class HashTable {

    private static final int TABLE_SIZE = 10;
    private HashItem[] hasTable;

    public HashTable() {
        hasTable = new HashItem[TABLE_SIZE];
    }

    // O(1) running time
    public int get(int key) {

        int index = hash(key);

        if (hasTable[index] == null) {
            return -1;
        }

        HashItem item = hasTable[index];

        // we have to find the item we are looking for in the LinkedList essentially
        // again this is why it may have O(N) linear running time complexity
        while (item != null && item.getKey() != key) {
            item = item.getNextItem();
        }

        if (item == null) {
            return -1;
        }

        return item.getValue();
    }

    // O(1) running time
    public void put(int key, int value) {

        int index = hash(key);

        // there is no collision (the index is empty)
        if (hasTable[index] == null) {
            System.out.println("No collision - simple insertion ...");
            hasTable[index] = new HashItem(key, value);
        } else {
            // we know that there is already an item at index
            System.out.println("Collision when inserting with key " + key);
            HashItem item = hasTable[index];

            // this is why the running time may be O(N)
            while (item.getNextItem() != null) {
                System.out.println("Considering the next item in linked list " + item.getValue());
                item = item.getNextItem();
            }

            System.out.println("Finally we have found the place to insert ...");
            item.setNextItem(new HashItem(key, value));
        }
    }

    // it transforms the key into an index of the underlying array
    private int hash(int key) {
        return key % TABLE_SIZE;
    }
}
