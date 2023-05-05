package com.phucdevs.interview_1.binaryheaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class App {

    public static void main(String[] args) {

        Heap heap = new Heap();

        heap.insert(6);
        System.out.println(heap.getMax());
        heap.insert(1);
        System.out.println(heap.getMax());
        heap.insert(12);
        System.out.println(heap.getMax());
        heap.insert(-2);
        System.out.println(heap.getMax());
        heap.insert(3);
        System.out.println(heap.getMax());
        heap.insert(8);
        System.out.println(heap.getMax());
        heap.insert(-5);
        System.out.println(heap.getMax());

        heap.heapSort();

        // by default the heap is MAX HEAP
        PriorityQueue<PersonHeap> heapPerson = new PriorityQueue<>(Collections.reverseOrder());

        // O(logN)
        heapPerson.add(new PersonHeap("Kevin", 34));
        heapPerson.add(new PersonHeap("Daniel", 12));
        heapPerson.add(new PersonHeap("Ana", 67));
        heapPerson.add(new PersonHeap("Adam", 18));
        heapPerson.add(new PersonHeap("Stephen", 52));
        heapPerson.add(new PersonHeap("Michael", 23));

        // when we consider all N items in O(logN) = O(NlogN)
        while (!heapPerson.isEmpty()) {
            // O(logN)
            System.out.println(heapPerson.poll());
        }
    }
}
