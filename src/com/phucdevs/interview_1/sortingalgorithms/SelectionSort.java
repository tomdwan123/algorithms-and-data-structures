package com.phucdevs.interview_1.sortingalgorithms;

public class SelectionSort {

    private int[] nums;

    public SelectionSort(int[] nums) {
        this.nums = nums;
    }

    public void sort() {

        for (int i = 0; i < nums.length - 1; ++i) {

            int index = i;
            for (int j  = i + 1; j < nums.length; ++j) {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }

            if (index != i) {
                swap(i, index);
            }
        }

        showSortedArray();
    }

    private void showSortedArray() {

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + " ");
        }
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
