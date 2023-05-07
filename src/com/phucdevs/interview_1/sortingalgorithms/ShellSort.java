package com.phucdevs.interview_1.sortingalgorithms;

public class ShellSort {

    private int[] nums;

    public ShellSort(int[] nums) {
        this.nums = nums;
    }

    public void sort() {

        for (int gap = nums.length/2; gap > 0; gap /= 2) {
            for (int i = gap; i < nums.length; ++i) {
                int j = i;

                while (j > gap && nums[j - gap] > nums[j]) {
                    swap(j, j - gap);
                    j -= gap;
                }
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
