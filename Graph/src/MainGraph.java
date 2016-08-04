import ru.academit.novikov.graph.Graph;

public class MainGraph {
    public static void main(String[] args) {

//                        0  1  2  3  4  5  6  7  8
// ===================================================
        int[][] arrayGraph = {
                {0, 1, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0, 0, 0}};

        int[][] arrayGraph2 = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0}};


        Graph G7 = new Graph(arrayGraph2);

        System.out.println();
        System.out.println("breadthFirstSearch");
        G7.breadthFirstSearch();
        System.out.println("\n");
        System.out.println("depthFirstSearch");
        G7.depthFirstSearch2(0);

        int[][] arrayGraph3 = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1},
                {0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1},
                {0, 1, 1, 1, 0}};

        System.out.println("\n");
        System.out.println("несвязный граф");
        Graph G9 = new Graph(arrayGraph3);
        G9.breadthFirstSearch();

    }
}