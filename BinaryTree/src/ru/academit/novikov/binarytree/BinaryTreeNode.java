package ru.academit.novikov.binarytree;

public class BinaryTreeNode {
    public BinaryTreeNode leftChild;
    public BinaryTreeNode rightChild;
    private int value;

    public BinaryTreeNode(int value) {
        leftChild = null;
        rightChild = null;
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}