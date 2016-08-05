package ru.academit.novikov.graph;

import java.util.*;

public class Graph {
    private final int[][] adjacentMatrix;
    private final int numbersOfVertices;
    private final Queue<Integer> queue = new LinkedList<>();
    private final Set<Integer> setOfVertices = new HashSet<>();

    public Graph(int[][] array) {
        numbersOfVertices = array.length;
        adjacentMatrix = new int[numbersOfVertices][numbersOfVertices];
        for (int i = 0; i < numbersOfVertices; i++) {
            System.arraycopy(array[i], 0, adjacentMatrix[i], 0, numbersOfVertices);
        }
    }

    private void visitDepth(int rootVertex) {
        setOfVertices.add(rootVertex);
        System.out.print(rootVertex + " ");
        for (int j = 0; j < numbersOfVertices; j++) {
            if (adjacentMatrix[rootVertex][j] == 1 && !setOfVertices.contains(j)) {
                setOfVertices.add(j);
                visitDepth(j);
            }
        }
    }

    public void depthFirstSearch(int x) {
        setOfVertices.clear();
        visitDepth(x);
        while (setOfVertices.size() < numbersOfVertices) {
            x++;
            visitDepth(x);
        }
    }


    
    private void visitBreadth() {
        int rootVertex = 0;
        queue.add(rootVertex);
        setOfVertices.add(rootVertex);
        System.out.print(rootVertex + " ");
        while (!queue.isEmpty()) {
            queue.remove();
            //int child = queue.remove();
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
        //setOfVertices.clear();
    }

    public void breadthFirstSearch() {
        setOfVertices.clear();
        visitBreadth();
    }

    private void visitBreadth2(int rootVertex) {
        //int rootVertex = 0;
        queue.add(rootVertex);
        setOfVertices.add(rootVertex);
        System.out.print(rootVertex + " ");
        while (!queue.isEmpty()) {
            queue.remove();
            //int child = queue.remove();
            //for (int i = 0; i < numbersOfVertices; i++) {
            for (int j = 0; j < numbersOfVertices; j++) {
                if (adjacentMatrix[rootVertex][j] == 1 && !setOfVertices.contains(j)) {
                    setOfVertices.add(j);
                    queue.add(j);
                    System.out.print(j + " ");
                }
            }
        }
        //}
        //setOfVertices.clear();
    }

    public void breadthFirstSearch2(int x) {
        setOfVertices.clear();
        visitBreadth2(x);
        while (setOfVertices.size() < numbersOfVertices) {
            x++;
            visitBreadth2(x);
        }
    }

    public void depthFirstSearch2(int x) {
        setOfVertices.clear();
        visitDepth(x);
        while (setOfVertices.size() < numbersOfVertices) {
            x++;
            visitDepth(x);
        }
    }
}