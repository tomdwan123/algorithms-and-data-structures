package com.phucdevs.interview_1.queues;

import java.util.Stack;

public class ImplementQueueWithStackProblem {

    public static void main(String[] args) {

        /**
         * The problem is that we want to implement queue abstract data type
         * with the enqueue() and dequeue() operations with stacks
         */
        QueueByStacks queue = new QueueByStacks();

        queue.enqueue(10);
        queue.enqueue(5);
        queue.enqueue(20);

        System.out.println(queue.dequeue());

        queue.enqueue(100);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}

class QueueByStacks {

    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public QueueByStacks() {
        this.enqueueStack = new Stack<>();
        this.dequeueStack = new Stack<>();
    }

    // O(1)
    public void enqueue(int item) {
        enqueueStack.push(item);
    }

    public int dequeue() {

        if (enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
            throw new RuntimeException("Stacks are empty...");
        }

        // if the dequeueStack is empty we need adding items O(N) time
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }

        // otherwise we just have to pop off an item in O(1)
        return dequeueStack.pop();
    }
}
