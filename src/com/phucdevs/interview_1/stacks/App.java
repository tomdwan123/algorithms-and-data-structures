package com.phucdevs.interview_1.stacks;

public class App {

    public static void main(String[] args) {

        Stack<String> names = new Stack<>();
        names.push("Adam");
        names.push("Ana");
        names.push("Kevin");
        names.push("Michael");

        while (!names.isEmpty()) {
            System.out.println(names.pop());
        }
    }
}
