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


    public void insert(int data) {
        root = insert(root, data);
    }

    private BinaryTreeNode insert(BinaryTreeNode current, int data) {
        if (current == null) {
            current = new BinaryTreeNode(data);
            //current.setValue(data);
            current.setLeftChild(null);
            current.setRightChild(null);
            //current.setParent(parent);
        } else if (data < current.getValue()) {
            current.setLeftChild(insert(current.getLeft(), data));
        } else {
            current.setRightChild(insert(current.getRight(), data));
        }
        return current;
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


    public BinaryTreeNode findMin() {
        BinaryTreeNode min = root;
        if (min == null) return null;
        while (min.leftChild != null) {
            min = min.leftChild;
        }
        return min;
    }

    public static void printFindMin(BinaryTree tree) {
        System.out.println("nodeMin = " + tree.findMin().getValue());
    }

    public static void printMin(BinaryTree tree) {
        //System.out.println("nodeMin = " + tree.min(node).getValue());
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