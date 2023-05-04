package com.phucdevs.interview_1.binarysearchtrees;

public class MinimumItemExercise {

    public static void main(String[] args) {

        BinarySearchMinTree<Integer> bst = new BinarySearchMinTree<>();

        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(14);
        bst.insert(16);
        bst.insert(-1);

        System.out.println(bst.getMin());
        System.out.println(bst.getMax());
        bst.traversal();
    }
}

class BinarySearchMinTree<T extends Comparable<T>> implements MinTree<T> {

    private MinNode<T> root;

    @Override
    public T getMin() {
        if (root == null) return null;

        return getMin(root);
    }

    private T getMin(MinNode<T> node) {

        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }

        return node.getData();
    }

    @Override
    public T getMax() {
        if (root == null) return null;

        return getMax(root);
    }

    private T getMax(MinNode<T> node) {

        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }

        return node.getData();
    }

    @Override
    public void traversal() {

        if (root == null) return;

        traversal(root);
    }

    private void traversal(MinNode<T> node) {

        if (node.getLeftChild() != null) {
            traversal(node.getLeftChild());
        }

        System.out.print(node.getData() + " - ");

        if (node.getRightChild() != null) {
            traversal(node.getRightChild());
        }
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
    public T getMax();
    public void traversal();
}
