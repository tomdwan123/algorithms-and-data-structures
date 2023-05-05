package com.phucdevs.interview_1.binaryheaps;

public class Exercise12 {

    public static void main(String[] args) {

        /**
         * Design an algorithms that is able to convert a maximum heap into a minimum heap!
         */
    }

    private int[] heap;

    public Exercise12(int[] heap) {
        this.heap = heap;
    }

    public int[] transform() {

        // we do not have to consider leaf nodes (thats why last node we have to consider has index (length - 2)/2
        for (int i  = (heap.length - 2)/2; i >= 0; i--) {
            // we "heapify" all the internal nodes: we check whether the parent is smaller than the children
            // if not: than we swap the nodes accordingly
            heapify(i);
        }

        return heap;
    }

    private void heapify(int index) {

        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestIndex = index;

        if (leftChildIndex < heap.length && heap[leftChildIndex] < heap[index]) {
            smallestIndex = leftChildIndex;
        }

        if (rightChildIndex < heap.length && heap[rightChildIndex] < heap[smallestIndex]) {
            smallestIndex = rightChildIndex;
        }

        if (smallestIndex != index) {
            swap(smallestIndex, index);
            heapify(smallestIndex);
        }
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
}
