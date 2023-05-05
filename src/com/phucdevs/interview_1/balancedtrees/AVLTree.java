package com.phucdevs.interview_1.balancedtrees;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {

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
        if(node.getData().compareTo(data) > 0) {
            // there is a valid (not NULL) left child so we go there
            if( node.getLeftChild() != null )
                insert(data, node.getLeftChild());
                // the left child is a NULL so we create a left child
            else
                node.setLeftChild(new Node<>(data, node));
            // this is the case when the data is GREATER than the value in the node
            // GO TO THE RIGHT SUBTREE
        } else {
            // there is a valid (not NULL) right child so we go there
            if( node.getRightChild() != null )
                insert(data, node.getRightChild());
                // the right child is a NULL so we create a right child
            else
                node.setRightChild(new Node<>(data, node));
        }

        updateHeight(node);
        settleViolations(node);
    }

    @Override
    public void remove(T data) {
        if (root != null)
            remove(data, root);
    }

    @Override
    public void traverse() {

    }

    private void settleViolations(Node<T> node) {

        // we have to check up to the root node O(logN)
        while (node != null) {
            updateHeight(node);
            settleViolationsHelper(node);
            node = node.getParentNode();
        }
    }

    private void settleViolationsHelper(Node<T> node) {

        int balance = getBalance(node);

        if (balance > 1) {
            if (getBalance(node.getLeftChild()) < 0) {
                leftRotation(node.getLeftChild());
            }

            rightRotation(node);
        }

        if (balance < -1) {
            if (getBalance(node.getRightChild()) > 0) {
                rightRotation(node.getRightChild());
            }

            leftRotation(node);
        }
    }

    // O(1)
    private void rightRotation(Node<T> node) {

        Node<T> tempLeftChild = node.getLeftChild();
        Node<T> grandChild = tempLeftChild.getRightChild();

        // make the rotation - the new root ill be the temLeftChild
        tempLeftChild.setRightChild(node);
        node.setLeftChild(grandChild);

        // we have to handle the parents
        if (grandChild != null) {
            grandChild.setParentNode(node);
        }

        // we have to handle the parents for the node
        Node<T> tempParentNode = node.getParentNode();
        node.setParentNode(tempLeftChild);
        tempLeftChild.setParentNode(tempParentNode);

        // Update the height of a given node
        if (
                tempLeftChild.getParentNode() != null
                && tempLeftChild.getParentNode().getLeftChild() == node
        ) {
            tempLeftChild.getParentNode().setLeftChild(tempLeftChild);
        }

        if (
                tempLeftChild.getParentNode() != null
                && tempLeftChild.getParentNode().getRightChild() == node
        ) {
            tempLeftChild.getParentNode().setRightChild(tempLeftChild);
        }

        // no parent after rotation because it has become the root node
        if (node == root) {
            root = tempLeftChild;
        }

        // after rotations the height parameters can change
        updateHeight(node);
        updateHeight(tempLeftChild);
    }

    // O(1)
    private void leftRotation(Node<T> node) {

        Node<T> tempRightChild = node.getRightChild();
        Node<T> grandChild = tempRightChild.getLeftChild();

        // make the rotation - the new root ill be the temLeftChild
        tempRightChild.setLeftChild(node);
        node.setRightChild(grandChild);

        // we have to handle the parents
        if (grandChild != null) {
            grandChild.setParentNode(node);
        }

        // we have to handle the parents for the node
        Node<T> tempParentNode = node.getParentNode();
        node.setParentNode(tempRightChild);
        tempRightChild.setParentNode(tempParentNode);

        // Update the height of a given node
        if (
                tempRightChild.getParentNode() != null
                && tempRightChild.getParentNode().getLeftChild() == node
        ) {
            tempRightChild.getParentNode().setLeftChild(tempRightChild);
        }

        if (
                tempRightChild.getParentNode() != null
                && tempRightChild.getParentNode().getRightChild() == node
        ) {
            tempRightChild.getParentNode().setRightChild(tempRightChild);
        }

        // no parent after rotation because it has become the root node
        if (node == root) {
            root = tempRightChild;
        }

        // after rotations the height parameters can change
        updateHeight(node);
        updateHeight(tempRightChild);
    }

    private void remove(T data, Node<T> node) {

        if (data.compareTo(node.getData()) < 0) {
            remove(data, node.getLeftChild());
        } else if (data.compareTo(node.getData()) > 0) {
            remove(data, node.getRightChild());
        } else {
            // we have found the item we want to remove

            // CASE 1: if the node is left node (without left or right child)
            if (node.getLeftChild() == null && node.getRightChild() == null) {
                // whether the node is a left child or right child
                Node<T> parentNode = node.getParentNode();

                // the node if left child
                if (parentNode != null && parentNode.getLeftChild() == node) {
                    parentNode.setLeftChild(null);
                    // the node is right child
                } else if (parentNode != null && parentNode.getRightChild() == node) {
                    parentNode.setRightChild(null);
                }

                // maybe the root node is the one we want to remove
                if (parentNode == null) {
                    root = null;
                }

                // remove the node and makes it eligible for GC
                node = null;
            }
            // CASE 2: when we remove items with a single child
            // a single right child
            else if (node.getLeftChild() == null && node.getRightChild() != null) {

                Node<T> parent = node.getParentNode();

                // the node is the left child
                if (parent != null && parent.getLeftChild() == node) {
                    parent.setLeftChild(node.getRightChild());
                    // the node is the right child
                } else if (parent != null && parent.getRightChild() == node) {
                    parent.setRightChild(node.getRightChild());
                }

                // when we deal with the root node
                if (parent == null) {
                    root = node.getRightChild();
                }

                // have to update the right child's parent
                node.getRightChild().setParentNode(parent);

                // remove the node and makes it eligible for GC
                node = null;

                updateHeight(parent);
            }
            // CASE 2: when we remove items with a single child
            // a single left child
            else if (node.getLeftChild() != null && node.getRightChild() == null) {

                Node<T> parent = node.getParentNode();

                // the node is the left child
                if (parent != null && parent.getLeftChild() == node) {
                    parent.setLeftChild(node.getLeftChild());
                    // the node is the right child
                } else if (parent != null && parent.getRightChild() == node) {
                    parent.setRightChild(node.getLeftChild());
                }

                // when we deal with the root node
                if (parent == null) {
                    root = node.getLeftChild();
                }

                // have to update the right child's parent
                node.getLeftChild().setParentNode(parent);

                // remove the node and makes it eligible for GC
                node = null;

                updateHeight(parent);
            }
            // CASE 3: remove 2 children
            else {
                // find the max item in the left subtree
                Node<T> predecessor = getPredecessor(node.getLeftChild());

                // swap just the values
                T temp = predecessor.getData();
                predecessor.setData(node.getData());
                node.setData(temp);

                // we have to call the delete method recursively on the predecessor
                remove(data, predecessor);
            }
        }
    }

    private void updateHeight(Node<T> node) {
        node.setHeight(
                Math.max(height(node.getLeftChild()), height(node.getRightChild()))
        );
    }

    private int height(Node<T> node) {

        if (node == null) return -1;

        return node.getHeight();
    }

    private int getBalance(Node<T> node) {

        if (node == null) return 0;

        return height(node.getLeftChild()) - height(node.getRightChild());
    }

    private Node<T> getPredecessor(Node<T> node) {

        if (node.getRightChild() != null) {
            return getPredecessor(node.getRightChild());
        }

        return node;
    }
}

