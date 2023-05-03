package com.phucdevs.interview_1.array;

public class PalindromeProblem {

    public static void main(String[] args) {

        /**
         * "A palindrome is a string that reads the same forward and backward"
         *
         * For example: radar or madam
         *
         * Your task is to design an optimal algorithm for checking whether a given string is palindrome or not!
         */
        System.out.println(solve1("radar"));
        System.out.println(solve1("madam"));
        System.out.println(solve1("radae"));
    }

    static boolean solve1(String s) {

        int length = s.toCharArray().length;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;
    }

    // It has O(N) running time
    static boolean solve2(String s) {

        int forward = 0;
        int backward = s.length() - 1;

        while (forward < backward) {
            if (s.charAt(forward) != s.charAt(backward)) {
                return false;
            }
        }

        return true;
    }
}
