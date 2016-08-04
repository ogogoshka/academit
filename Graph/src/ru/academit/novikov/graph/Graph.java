package ru.academit.novikov.graph;

import java.util.*;

public class Graph {
    private int[][] adjacentMatrix;
    private int numbersOfVertices;
    private Queue<Integer> queue = new LinkedList<>();
    private Set<Integer> setOfVertices = new HashSet<>();

    public Graph() {
    }

    public Graph(int[][] array) {
        numbersOfVertices = array.length;
        adjacentMatrix = new int[numbersOfVertices][numbersOfVertices];
        for (int i = 0; i < numbersOfVertices; i++)
            System.arraycopy(array[i], 0, adjacentMatrix[i], 0, numbersOfVertices);
    }

    public void breadthFirstSearch() {
        int rootNode = 0;
        queue.add(rootNode);
        setOfVertices.add(rootNode);
        System.out.print(rootNode + " ");
        while (!queue.isEmpty()) {
            queue.remove();
            for (int i = 0; i < numbersOfVertices; i++) {
                for (int j = 0; j < numbersOfVertices; j++) {
                    if (adjacentMatrix[i][j] == 1 && !setOfVertices.contains(j)) {
                        setOfVertices.add(j);
                        queue.add(j);
                        System.out.print(j + " ");
                    }
                }
            }
        }
        setOfVertices.clear();
    }

    public void depthFirstSearch(int rootNode) {
        setOfVertices.add(rootNode);
        System.out.print(rootNode + " ");
        for (int i = rootNode; i < numbersOfVertices; i++) {
            for (int j = 0; j < numbersOfVertices; j++) {
                if (adjacentMatrix[i][j] == 1 && !setOfVertices.contains(j)) {
                    setOfVertices.add(j);
                    depthFirstSearch(j);
                }
            }
        }
    }
}
/*
        for (int j = 0; j < numbersOfVertices; j++) {
            if (adjacentMatrix[rootNode][j] == 1 && !setOfVertices.contains(j)) {
                setOfVertices.add(j);
                System.out.print(j + " ");
                depthFirstSearch(j);
            }
        }


        while (rootNode < numbersOfVertices) {
            for (int j = 0; j < numbersOfVertices; j++) {
                if (adjacentMatrix[rootNode][j] == 1 && !setOfVertices.contains(j)) {
                    setOfVertices.add(j);
                    System.out.print(j + " ");
                }
            }
            rootNode++;
        }



    //System.out.print(node.getValue() + " ");
    //for (TreeNode child : node.childrenArray) {
    //dfs(child);
    //}


    public void depthFirstSearch(int rootNode) {
        rootNode = 0;
        Set<Integer> setOfVertices = new HashSet<>();
        setOfVertices.add(rootNode);
        System.out.print(rootNode + " ");

        for (int j = 0; j < numbersOfVertices; j++) {
            if (adjacentMatrix[rootNode][j] == 1 && !setOfVertices.contains(j)) {
                setOfVertices.add(j);
                System.out.print(j + " ");
                depthFirstSearch(j);
            }
        }


        while (rootNode < numbersOfVertices) {
            for (int j = 0; j < numbersOfVertices; j++) {
                if (adjacentMatrix[rootNode][j] == 1 && !setOfVertices.contains(j)) {
                    setOfVertices.add(j);
                    System.out.print(j + " ");
                }
            }
            rootNode++;
        }

        //System.out.print(node.getValue() + " ");
        //for (TreeNode child : node.childrenArray) {
        //dfs(child);
        //}
    }
}
 */