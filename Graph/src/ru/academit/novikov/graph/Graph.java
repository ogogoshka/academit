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
                visitDepth(j);
            }
        }
    }

    public void depthFirstSearch() {
        int x = 0;
        setOfVertices.clear();
        visitDepth(x);
        while (setOfVertices.size() < numbersOfVertices) {
            x++;
            visitDepth(x);
        }
    }

    private void visitBreadth(int rootVertex) {
        if (!setOfVertices.contains(rootVertex)) {
            queue.add(rootVertex);
            setOfVertices.add(rootVertex);
            System.out.print(rootVertex + " ");
        }
        while (!queue.isEmpty()) {
            int child = queue.remove();
            for (int j = 0; j < numbersOfVertices; j++) {
                if (adjacentMatrix[child][j] == 1 && !setOfVertices.contains(j)) {
                    setOfVertices.add(j);
                    queue.add(j);
                    System.out.print(j + " ");
                }
            }
        }
    }

    public void breadthFirstSearch() {
        setOfVertices.clear();
        for (int i = 0; i < numbersOfVertices; i++) {
            visitBreadth(i);
        }
    }

}