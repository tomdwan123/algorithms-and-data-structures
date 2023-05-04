package com.phucdevs.interview_1.binarysearchtrees;

public class MinimumItemExercise {

    public static void main(String[] args) {


    }
}

class BinarySearchMinTree<T extends Comparable<T>> implements MinTree<T> {

    private MinNode<T> root;

    @Override
    public T getMin() {
        // your implementation here !!! (you may have to define helper methods if needed)
        if (root == null) {
            return null;
        } else {
            return getPreOrderTraverse(root);
        }
    }

    private T getPreOrderTraverse(MinNode<T> node) {
        if (node.getLeftChild() != null) {
            return getPreOrderTraverse(node.getLeftChild());
        }

        return node.getData();
    }

    @Override
    public void insert(T data) {
        // this is when we insert the first node into the BST (parent is null)
        if(root==null) {
            root = new MinNode<>(data, null);
        } else {
            // there are already items in the BST
            insert(data, root);
        }
    }

    private void insert(T data, MinNode<T> node) {
        // this is the case when the data is SMALLER than the value in the node
        // GO TO THE LEFT SUBTREE
        if(node.getData().compareTo(data) > 0) {
            // there is a valid (not NULL) left child so we go there
            if( node.getLeftChild() != null )
                insert(data, node.getLeftChild());
                // the left child is a NULL so we create a left child
            else
                node.setLeftChild(new MinNode<>(data, node));
            // this is the case when the data is GREATER than the value in the node
            // GO TO THE RIGHT SUBTREE
        } else {
            // there is a valid (not NULL) right child so we go there
            if( node.getRightChild() != null )
                insert(data, node.getRightChild());
                // the right child is a NULL so we create a right child
            else
                node.setRightChild(new MinNode<>(data, node));
        }
    }
}

class MinNode<T> {

    private T data;
    private MinNode<T> leftChild;
    private MinNode<T> rightChild;
    private MinNode<T> parentNode;

    public MinNode(T data, MinNode<T> parentNode) {
        this.data = data;
        this.parentNode = parentNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MinNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(MinNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public MinNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(MinNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public MinNode<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(MinNode<T> parentNode) {
        this.parentNode = parentNode;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}

interface MinTree<T> {
    public void insert(T data);
    public T getMin();
}
