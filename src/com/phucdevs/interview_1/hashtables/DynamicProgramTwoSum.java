package com.phucdevs.interview_1.hashtables;

import java.util.HashMap;
import java.util.Map;

public class DynamicProgramTwoSum {

    // the on-dimensional array in which we store the integers
    private int[] nums;
    // the S target we are after
    private int S;
    private Map<Integer, Integer> hastTable;

    public DynamicProgramTwoSum(int[] nums, int S) {
        this.nums = nums;
        S = S;
        this.hastTable = new HashMap<>();
    }

    // we can eliminate the second for loop with a hash table (running time memory complexity tradeoff)
    public void solve() {

        // consider all the items once so it has O(N) linear running time complexity
        for (int i = 0; i < nums.length; ++i) {

            // check the remainder (actual value - target value)
            int remainder = S - nums[i];

            // check if the remainder exists in the hashtable: it means we have found a pair
            // O(1)
            if (hastTable.containsValue(remainder)) {
                System.out.println("Solution: " + nums[i] + "+" + remainder + "=" + S);
            }

            // add the current number to the hashtable
            hastTable.put(i, nums[i]);
        }
    }
}
