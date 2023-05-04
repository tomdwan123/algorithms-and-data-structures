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
    public void remove(T data) {
        if (root != null)
            remove(data, root);
    }

    @Override
    public boolean isEqualsTrees(MinNode<T> node1, MinNode<T> node2) {

        if (
                (node1 == null && node2 == null)
                || (node1 == null && node2 != null)
                || (node1 != null && node2 == null)
        ) {
            return node1 == node2;
        }

        if (node1.getData().compareTo(node2.getData()) != 0) {
            return false;
        }

        return isEqualsTrees(node1.getLeftChild(), node2.getLeftChild())
                && isEqualsTrees(node1.getRightChild(), node2.getRightChild());
    }

    @Override
    public MinNode<T> getKSmallest(MinNode<T> node, int k) {
        /**
         * Write an efficient in-place algorithm to find the k-th smallest item in a binary search tree!
         */
        int n = treeSize(node.getLeftChild()) + 1;

        // this is when we find the kth smallest item
        if (n == k) {
            return node;
        }

        if (n > k) {
            return getKSmallest(node.getLeftChild(), k);
        }

        if (n < k) {
           return  getKSmallest(node.getRightChild(), k - n);
        }

        return null;
    }

    @Override
    public int getTotalAge(MinNode<T> node) {

        int sum = 0;
        int leftSum = 0;
        int rightSum = 0;

        if (node == null) {
            return 0;
        }

        leftSum = getTotalAge(node.getLeftChild());
        rightSum = getTotalAge(node.getRightChild());

        sum = ((Person) node.getData()).getAge() + leftSum + rightSum;
        return sum;
    }

    // calculate the size of a substree with root node 'node'
    private int treeSize(MinNode<T> node) {
        if(node == null) return 0;

        int num = (treeSize(node.getLeftChild())+treeSize(node.getRightChild())+1);
        return num;
    }

    private void remove(T data, MinNode<T> node) {

        if (data.compareTo(node.getData()) < 0) {
            remove(data, node.getLeftChild());
        } else if (data.compareTo(node.getData()) > 0) {
            remove(data, node.getRightChild());
        } else {
            // we have found the item we want to remove

            // CASE 1: if the node is left node (without left or right child)
            if (node.getLeftChild() == null && node.getRightChild() == null) {
                // whether the node is a left child or right child
                MinNode<T> parentNode = node.getParentNode();

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

                MinNode<T> parent = node.getParentNode();

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
            }
            // CASE 2: when we remove items with a single child
            // a single left child
            else if (node.getLeftChild() != null && node.getRightChild() == null) {

                MinNode<T> parent = node.getParentNode();

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
            }
            // CASE 3: remove 2 children
            else {
                // find the max item in the left subtree
                MinNode<T> predecessor = getPredecessor(node.getLeftChild());

                // swap just the values
                T temp = predecessor.getData();
                predecessor.setData(node.getData());
                node.setData(temp);

                // we have to call the delete method recursively on the predecessor
                remove(data, predecessor);
            }
        }

    }

    private MinNode<T> getPredecessor(MinNode<T> node) {

        if (node.getRightChild() != null) {
            return getPredecessor(node.getRightChild());
        }

        return node;
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
    public void remove(T data);
    public boolean isEqualsTrees(MinNode<T> node1, MinNode<T> node2);
    public MinNode<T> getKSmallest(MinNode<T> node, int k);
    public int getTotalAge(MinNode<T> node);
}

class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        return -(age - person.getAge());
    }

    @Override
    public String toString() {
        return this.name + "-" + this.age;
    }
}