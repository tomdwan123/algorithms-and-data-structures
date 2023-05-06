package com.phucdevs.interview_1.hashtables;

public class HashTableLinearProbing {

    private static final int TABLE_SIZE = 10;
    private HashItemLinearProbing[] hasTable;
    // it tracks the number of key-value pairs already stored in the table
    private int counter;

    public HashTableLinearProbing() {
        hasTable = new HashItemLinearProbing[TABLE_SIZE];
    }

    // O(1) running time
    public int get(int key) {

        int index = hash(key);

        // BECAUSE OF COLLISION !!!
        while (hasTable[index] != null & hasTable[index].getKey() != key) {
            index = (index + 1) % TABLE_SIZE;
        }

        // search miss
        if (hasTable[index] == null) {
            return  -1;
        }

        return hasTable[index].getValue();
    }

    // O(1) running time
    public void put(int key, int value) {

        if (counter >= TABLE_SIZE) {
            return;
        }

        int index = hash(key);

        // until we do not find an empty slot (null) we keep generating
        // the next index (linear probing)
        while (hasTable[index] != null) {
            index = (index + 1) / TABLE_SIZE;
        }

        // we have found a valid index for the new item
        hasTable[index] = new HashItemLinearProbing(key, value);


        counter++;
    }

    // it transforms the key into an index of the underlying array
    private int hash(int key) {
        return key % TABLE_SIZE;
    }
}
