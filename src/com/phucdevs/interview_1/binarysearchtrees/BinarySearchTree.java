package com.phucdevs.interview_1.binarysearchtrees;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void insert(T data) {

        if (root == null) {
            root = new Node<>(data, null);
        } else {
            insert(data, root);
        }
    }

    private void insert(T data, Node<T> node) {

        // this is the case when the data is SMALLER than the value in the node
        // GO TO THE LEFT SUBTREE
        if (node.getData().compareTo(data) > 0) {
            // if the LEFT CHILD is NOT NULL so we go there
            if (node.getLeftNode() != null) {
                insert(data, node.getLeftNode());
            } else {
                node.setLeftNode(new Node<>(data, node));
            }
        // GO TO THE RIGHT SUBTREE
        } else {
            if (node.getRightNode() != null) {
                insert(data, node.getRightNode());
            } else {
                node.setRightNode(new Node<>(data, node));
            }
        }
    }

    @Override
    public void remove(T data) {

    }

    @Override
    public void traversal() {

    }

    @Override
    public T getMin() {
        return null;
    }

    @Override
    public T getMax() {
        return null;
    }
}
