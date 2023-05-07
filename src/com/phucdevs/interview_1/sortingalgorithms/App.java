package com.phucdevs.interview_1.sortingalgorithms;

public class App {

    public static void main(String[] args) {

        int[] nums1 = {5, 2, 8, 10, 1, 0, 11};

        long start = System.currentTimeMillis();
        BubbleSort bubbleSort = new BubbleSort(nums1);
        bubbleSort.sort();
        System.out.println("Bubble sort is running time: " + (System.currentTimeMillis() - start) + " (ms)");

        int[] nums2 = {5, 2, 8, 10, 1, 0, 11};
        start = System.currentTimeMillis();
        SelectionSort selectionSort = new SelectionSort(nums2);
        selectionSort.sort();
        System.out.println("Selection sort is running time: " + (System.currentTimeMillis() - start) + " (ms)");

        int[] nums3 = {5, 2, 8, 10, 1, 0, 11};
        start = System.currentTimeMillis();
        InsertionSort insertionSort = new InsertionSort(nums3);
        insertionSort.sort();
        System.out.println("Insertion sort is running time: " + (System.currentTimeMillis() - start) + " (ms)");

        int[] nums4 = {5, 2, 8, 10, 1, 0, 11};
        start = System.currentTimeMillis();
        ShellSort shellSort = new ShellSort(nums4);
        shellSort.sort();
        System.out.println("Shell sort is running time: " + (System.currentTimeMillis() - start) + " (ms)");
    }

}
