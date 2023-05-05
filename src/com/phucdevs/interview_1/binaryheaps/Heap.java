package com.phucdevs.interview_1.binaryheaps;

public class Heap {

    private int[] heap;
    private int heapSize;

    public Heap() {
        heap  = new int[Constants.CAPACITY];
    }

    public void insert(int data) {

        if (isFull()) {
            throw new RuntimeException("Heap is full...");
        }

        // we append the data to the end of the array
        heap[heapSize] = data;
        heapSize++;

        // we have to check the heap properties - we start with the last item
        // that has index heapSize - 1
        // we have to check the nodes (parent nodes) up to the root node O(logN)
        fixUp(heapSize - 1);
    }

    private void fixUp(int index) {

        // index of the parent
        int parentIndex = (index-1)/2;

        // in worst-case we have to consider all the nodes up to the root node (index 0)
        // in a maximum heap the parent is always larger
        if (index > 0 && heap[index] > heap[parentIndex]) {
            swap(index, parentIndex);
            fixUp(parentIndex);
        }
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    private boolean isFull() {
        return heapSize == heap.length;
    }
}
