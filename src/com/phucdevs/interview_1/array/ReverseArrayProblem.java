package com.phucdevs.interview_1.array;

public class ReverseArrayProblem {

    public int[] solve(int[] nums) {

        // hint: define 2 pointers (pointing to the last and first item of the array) and make a single iteration ...
        int size = nums.length;
        for (int i = 0; i < size / 2; i++) { // 0 - 2
            swap(nums, i, (size - i - 1));
        }

        return nums;
    }

    private void swap(int[] nums, int index1, int index2) {

        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}