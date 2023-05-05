package com.phucdevs.interview_1.binaryheaps;

public class Exercise11 {

    public static void main(String[] args) {

        /**
         * Design an algorithms that can check whether a heap (with array representation) is a valid min heap or not.
         *
         * Note: a valid min heap is when the parent node is smaller than the children - for all the nodes in the heap.
         */

    }

    static boolean isMinHeap(int[] heap) {
        // leaf nodes do not have children
        // if 2*i+2 >= N then we know that node is a lead node (no need to consider)
        // so we have to rearrange the equation to get how many nodes to consider
        for (int i = 0; i < (heap.length - 2) / 2; i++) {
            // for non lead nodes we just have to check the min heap properties
            if (heap[i] > heap[2 * i + 1] || heap[i] > heap[2 * i + 2]) {
                return false;
            }
        }

        return true;
    }
}
