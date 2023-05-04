package com.phucdevs.interview_1.linkedlist;

public class Exercise5 implements List1 {

    // this is the head node or root node
    private Node1 root;
    private int numOfItems;

    @Override
    public Node1 getMiddleNode() {

        // this is where you implement the algorithm !!!
        // input1: [1, 2, 3, 4]
        // output1: 3
        // input2: [1, 2, 3, 4, 5]
        // output2: 3
        Node1 slow = root;
        Node1 fast = root;

        while (fast.getNextNode() != null && fast.getNextNode().getNextNode() != null) {
            slow = slow.getNextNode();
            fast = fast.getNextNode().getNextNode();
        }

        return slow;
    }

    @Override
    public void reverse() {

        // this is where you implement the algorithm !!!
        // input: [1, 2, 3, 4]
        // output: [4, 3, 2, 1]
        Node1 currentNode = this.root;
        Node1 previousNode = null;
        Node1 nextNode = null;

        while (currentNode != null) {

            nextNode = currentNode.getNextNode();
            currentNode.setNextNode(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }

        this.root = previousNode;
    }

    @Override
    public void insert(int data) {

        if(root==null) {
            // this is the first item in the linked list
            root = new Node1(data);
        } else {
            // we know that this is not the first item in the linked list
            insertBeginning(data);
        }
    }

    // we just have to update the references O(1)
    private void insertBeginning(int data) {
        Node1 newNode = new Node1(data);
        newNode.setNextNode(root);
        root = newNode;
    }

    // because we have to start with the root node
    // first we have to find the last node in O(N)
    private void insertEnd(int data, Node1 node) {

        // this is when we keep looking for the last node O(N)
        if(node.getNextNode() != null) {
            insertEnd(data, node.getNextNode());
        } else {
            // we have found the last node
            Node1 newNode = new Node1(data);
            node.setNextNode(newNode);
        }
    }

    @Override
    public void traverse() {

        if(root==null) return;

        Node1 actualNode = root;

        while(actualNode != null) {
            System.out.println(actualNode);
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public int size() {
        return numOfItems;
    }
}

interface List1 {
    public Node1 getMiddleNode();

    void reverse();

    public void insert(int data);
    public void traverse();
    public int size();
}

class Node1 {

    private int data;
    private Node1 nextNode;

    public Node1(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node1 getNextNode() {
        return nextNode;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNextNode(Node1 nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "" + this.data;
    }
}
