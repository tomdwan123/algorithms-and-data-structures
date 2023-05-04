package com.phucdevs.interview_1.stacks;

public class MaxItemStackProblem {

    private Stack<Integer> mainStack;
    private Stack<Integer> maxStack;

    public MaxItemStackProblem() {
        this.mainStack = new Stack<>();
        this.maxStack = new Stack<>();
    }

    public void push(int item) {

        mainStack.push(item);

        if (mainStack.size() == 1) {
            mainStack.push(item);
            return;
        }

        if (item > maxStack.peek()) {
            maxStack.push(item);
        } else {
            maxStack.push(maxStack.peek());
        }
    }

    public int pop() {
        maxStack.pop();
        return mainStack.pop();
    }

    public int getMaxItem() {
        return maxStack.peek();
    }

    public static void main(String[] args) {

        /**
         * The aim is to design an algorithm that can return the maximum item of a stack in O(1)
         * running time complexity. We can use O(N) extra memory!
         *
         * Hint: we can use another stack to track the max item
         */
        MaxItemStackProblem maxItemStack = new MaxItemStackProblem();

        maxItemStack.push(10);
        maxItemStack.push(5);
        maxItemStack.push(1);
        maxItemStack.push(12);
        maxItemStack.push(11);

        System.out.println(maxItemStack.getMaxItem());

    }
}
