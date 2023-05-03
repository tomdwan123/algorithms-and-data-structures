package com.phucdevs.interview_1.array;

public class ReverseArrayProblem {

    public static void main(String[] args) {

        /**
         * Input: [2, 10, 5, 3, 4, 9, 6, 8]
         * Output: [8, 6, 9, 4, 3, 5, 10, 2]
         */
        int[] nums = {2, 10, 5, 3, 4, 9, 6, 8};
        solve1(nums);
        solve2(nums);
    }

    static int[] solve1(int[] nums) {

        int size = nums.length;
        for (int i = 0; i < size / 2; i++) { // 0 - 2
            swap(nums, i, (size - i - 1));
        }

        return nums;
    }

    static int[] solve2(int[] nums) {

        int lowIndex = 0;
        int highIndex = nums.length - 1;

        while (lowIndex < highIndex) {
            swap(nums, lowIndex, highIndex);
            lowIndex++;
            highIndex--;
        }

        return nums;
    }

    static void swap(int[] nums, int index1, int index2) {

        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}