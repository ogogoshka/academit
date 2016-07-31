package ru.academit.novikov.binarytree;

public class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTree() {
        root = null;
    }

    //public boolean isEmpty() {
    //return root == null;
    //}

    private boolean search(BinaryTreeNode node, int x) {
        boolean isFound = false;

        while (node != null && !isFound) {
            if (node.getValue() > x) {
                node = node.leftChild;
            } else if (node.getValue() < x) {
                node = node.rightChild;
            } else {
                //isFound = true;
                return true;
            }
            isFound = search(node, x);
        }
        return isFound;
    }

    public boolean search(int x) {
        return search(root, x);
    }


    private BinaryTreeNode add(BinaryTreeNode node, int x) {
        if (node == null) {
            node = new BinaryTreeNode(x);
        } else if (x < node.getValue()) {
            node.leftChild = add(node.leftChild, x);
        } else if (x > node.getValue()) {
            node.rightChild = add(node.rightChild, x);
        }
        return node;
    }

    public void add(int value) {
        if (root == null) {
            root = new BinaryTreeNode(value);
        }
        root = add(root, value);
    }


    private BinaryTreeNode min(BinaryTreeNode node) {
        if (node.leftChild == null) {
            return node;
        } else {
            return min(node.leftChild);
        }
    }

    private BinaryTreeNode deleteMin(BinaryTreeNode node) {
        if (node.leftChild == null) {
            return node.rightChild;
        }
        node.leftChild = deleteMin(node.leftChild);
        return node;
    }

    private BinaryTreeNode delete(BinaryTreeNode node, int x) {
        if (node.getValue() < x) {
            node.rightChild = delete(node.rightChild, x);
        } else if (node.getValue() > x) {
            node.leftChild = delete(node.leftChild, x);
        } else {
            if (node.rightChild == null) {
                return node.leftChild;
            }
            if (node.leftChild == null) {
                return node.rightChild;
            }
            BinaryTreeNode temp = node;
            node = min(temp.rightChild);
            node.rightChild = deleteMin(temp.rightChild);
            node.leftChild = temp.leftChild;
        }
        return node;
    }

    public BinaryTreeNode delete(int x) {
        return delete(root, x);
    }

}