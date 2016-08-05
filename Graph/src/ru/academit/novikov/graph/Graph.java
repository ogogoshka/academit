package ru.academit.novikov.graph;

import java.util.*;

public class Graph {
    private int[][] adjacentMatrix;
    private int numbersOfVertices;
    private Queue<Integer> queue = new LinkedList<>();
    private Set<Integer> setOfVertices = new HashSet<>();

    public Graph(int[][] array) {
        numbersOfVertices = array.length;
        adjacentMatrix = new int[numbersOfVertices][numbersOfVertices];
        for (int i = 0; i < numbersOfVertices; i++)
            System.arraycopy(array[i], 0, adjacentMatrix[i], 0, numbersOfVertices);
    }

    public void breadthFirstSearch() {
        int rootVertex = 0;
        queue.add(rootVertex);
        setOfVertices.add(rootVertex);
        System.out.print(rootVertex + " ");
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

    private void visit(int rootVertex) {
        setOfVertices.add(rootVertex);
        System.out.print(rootVertex + " ");
        for (int i = rootVertex; i < numbersOfVertices; i++) {
            for (int j = 0; j < numbersOfVertices; j++) {
                if (adjacentMatrix[i][j] == 1 && !setOfVertices.contains(j)) {
                    setOfVertices.add(j);
                    visit(j);
                }
            }
        }
    }

    public void depthFirstSearch(int x) {
        setOfVertices.clear();
        visit(x);
    }


}