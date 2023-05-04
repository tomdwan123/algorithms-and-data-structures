package com.phucdevs.interview_1.queues;

public class App {

    public static void main(String[] args) {

        Queue<Object> queue = new Queue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue());
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
    }
}
