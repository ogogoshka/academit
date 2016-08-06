import ru.academit.novikov.graph.Graph;

public class MainGraph {
    public static void main(String[] args) {

        int[][] arrayGraph = {
                {0, 1, 0, 0, 1},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0}};

        int[][] arrayGraph2 = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0}};

        int[][] arrayGraph3 = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1},
                {0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1},
                {0, 1, 1, 1, 0}};

        Graph G1 = new Graph(arrayGraph);
        Graph G2 = new Graph(arrayGraph2);
        Graph G3 = new Graph(arrayGraph3);

        G1.breadthFirstSearch();
        System.out.println();
        G1.depthFirstSearch();
        System.out.println();

        G2.breadthFirstSearch();
        System.out.println();
        G2.depthFirstSearch();
        System.out.println();

        G3.breadthFirstSearch();
        System.out.println();
        G3.depthFirstSearch();
        System.out.println();


    }
}