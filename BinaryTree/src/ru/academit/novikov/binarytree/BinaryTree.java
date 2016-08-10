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
        if (node != null) {
            if (node.getValue() > x) {
                node = node.leftChild;
            } else if (node.getValue() < x) {
                node = node.rightChild;
            } else {
                return true;
            }
            isFound = search(node, x);
        }
        return isFound;
    }

    public boolean search(int x) {
        return search(root, x);
    }

    private void add(BinaryTreeNode node, int x) {
        if (x < node.getValue()) {
            if (node.leftChild == null) {
                node.leftChild = new BinaryTreeNode(x);
            } else {
                add(node.leftChild, x);
            }
        } else {
            if (node.rightChild == null) {
                node.rightChild = new BinaryTreeNode(x);
            } else {
                add(node.rightChild, x);
            }
        }
    }

    public void add(int value) {
        if (root == null) {
            root = new BinaryTreeNode(value);
        } else {
            add(root, value);
        }
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
            node = node.rightChild;
            return node;
        } else {
            node.leftChild = deleteMin(node.leftChild);
            return node;
        }
    }

    private BinaryTreeNode delete(BinaryTreeNode node, int x) {
        if (this.root.getValue() == x) {
            BinaryTreeNode temp = this.root;
            this.root = min(temp.rightChild);
            this.root.rightChild = deleteMin(temp.rightChild);
            this.root.leftChild = temp.leftChild;
            return this.root;
        }

        if (node.getValue() < x) {
            node.rightChild = delete(node.rightChild, x);
        } else if (node.getValue() > x) {
            node.leftChild = delete(node.leftChild, x);
        } else if (node.leftChild != null && node.rightChild != null) {
            BinaryTreeNode temp = node;
            node = min(temp.rightChild);
            node.rightChild = deleteMin(temp.rightChild);
            node.leftChild = temp.leftChild;
        } else {
            if (node.leftChild != null) {
                return node.leftChild;
            } else {
                return node.rightChild;
            }
        }
        return node;
    }

    public BinaryTreeNode delete(int x) {
        if (root == null) {
            return null;
        } else {
            return delete(root, x);
        }
    }

}