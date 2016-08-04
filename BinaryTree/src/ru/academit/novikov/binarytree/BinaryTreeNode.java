package ru.academit.novikov.binarytree;

public class BinaryTreeNode {
    public BinaryTreeNode leftChild;
    public BinaryTreeNode rightChild;
    private int value;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryTreeNode getRight() {
        return this.rightChild;
    }

    public BinaryTreeNode getLeft() {
        return this.leftChild;
    }


}