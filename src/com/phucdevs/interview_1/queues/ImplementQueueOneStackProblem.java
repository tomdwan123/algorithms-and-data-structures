package com.phucdevs.interview_1.queues;

import com.phucdevs.interview_1.stacks.Stack;

public class ImplementQueueOneStackProblem {

    public static void main(String[] args) {

    }

    private Stack<Integer> stack;

    public ImplementQueueOneStackProblem() {
        this.stack = new Stack<>();
    }

    // O(1)
    public void enqueue(int item) {
        this.stack.push(item);
    }

    public int dequeue() {

        if (stack.size() == 1) {
            return stack.pop();
        }

        // we keep popping the items until we find the last one
        int item = stack.pop();

        // we call the method recursively
        int lastDequeueItem = dequeue();

        // after we find the last one item we have to reinsert the items one by one
        enqueue(item);

        return lastDequeueItem;
    }
}
