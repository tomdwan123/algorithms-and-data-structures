package com.phucdevs.interview_1.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayExample {

    public static void main(String[] args) {

        example1();
        example2();
    }

    private static void example1() {
        // array are not dynamic array - we need define size at before
        int[] nums = new int[10];

        // random indexing: we can use the indexs of the array slots
        // O(1)
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        // (O1)
        nums[0] = 100;

        // if we dont know the index of the item
        // LINEAR SEARCHING -> O(N)
        //  we want to find the index of item = 6
        // O(N)

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 6) {
                System.out.println("We have found item at the index " + i);
            }
        }
    }

    static void example2() {

        // Init dynamic array with capacity = 10
        // New array has capacity = 10 + 10/2 = 15
        List<String> items = new ArrayList<>();

        items.add("a");
        items.add("b");
        items.add("c");
        items.add("d");

        System.out.println(items.get(0)); // O(1)

        items.remove(0); // O(N)
        System.out.println(items.get(0));
    }
}
