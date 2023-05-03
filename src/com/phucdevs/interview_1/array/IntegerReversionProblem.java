package com.phucdevs.interview_1.array;

public class IntegerReversionProblem {

    public static void main(String[] args) {

        /**
         * Your task is to design an efficient algorithm to reverse a given integer.
         * For example if the input of the algorithm is 1234 then the output should be 4321.
         *
         * NOTE: the input is an integer (and not a string) !!!
         */

        System.out.println(reverse(1234));
    }

    static int reverse(int n) {


        int reversed = 0;
        int remainder = 0;

        // algorithm here
        while (n > 0) {
            remainder = n % 10;
            n = n / 10;
            reversed = reversed * 10 + remainder; // n = 1234 remainder = 4 reversed = 0 + 3 => 4
            // n = 123 remainder = 3 reversed = 40 + 3 => 43
            // n = 12 remainder = 2 reversed = 430 + 2 = 432
            // n = 1 remainder = 1 reversed = 4320 + 1 = 4321
        }

        return reversed;
    }
}
