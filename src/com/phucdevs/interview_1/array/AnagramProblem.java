package com.phucdevs.interview_1.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AnagramProblem {

    public static void main(String[] args) {

        /**
         * Your task is to construct an algorithm to check whether two words (or phrases) are anagrams or not!
         * "An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
         * typically using all the original letters exactly once"
         * For example: restful and fluster are anagrams.
         */
        char[] s1 = "restful".toCharArray();
        char[] s2 = "fluster".toCharArray();
        System.out.println(solve1(s1, s2));
    }

    static boolean solve1(char[] s1, char[] s2) {

        if (s1.length != s2.length) {
            return false;
        }

        // The overall running time is O(N) * O() = O(N)2
        for (int i = 0; i < s1.length; i++) { // O(N)
            boolean isExist = false;
            for (int j = 0; j < s2.length; j++) { // O(N)
                if (s2[j] == s1[i]) {
                    isExist = true;
                    break;
                }
            }

            if (!isExist) {
                return false;
            }
        }

        return true;
    }

    static boolean solve2(char[] s1, char[] s2) {

        if (s1.length != s2.length) {
            return false;
        }

        // sort the letters of the strings
        // O(NlogN) this is the "bottleneck" of the algorithm
        Arrays.sort(s1);
        Arrays.sort(s2);

        // consider all the letters one by one and we have to compare these letters
        // O(N) but the overall running time is O(NlogN) + O(N) = O(NlogN)
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }

        return true;
    }
}
