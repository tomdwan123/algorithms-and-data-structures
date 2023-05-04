package com.phucdevs.interview_1.comparerunningtime;

import com.phucdevs.interview_1.linkedlist.LinkedList;

import java.util.ArrayList;

public class RunningTimeArrayLinkedList {

    public static void main(String[] args) {

        ArrayList<Object> array = new ArrayList<>();
        long now = System.currentTimeMillis();

        for (int i = 0; i < 500_000; i++) {
            array.add(0, i);
        }

        System.out.println("Running time for ArrayList is: " + (System.currentTimeMillis() - now));

        LinkedList<Integer> linked = new LinkedList<>();
        now = System.currentTimeMillis();

        for (int i = 0; i < 500_000; i++) {
            linked.insertBeginning(i);
        }

        System.out.println("Running time for LinkedList is: " + (System.currentTimeMillis() - now));
    }
}
