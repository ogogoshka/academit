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

        int[][] arrayGraph4 = {
                {0, 1, 0, 0, 1},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0}};
/*


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
        G7.depthFirstSearch(0);

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
        System.out.println("\n");



        Graph Gbig = new Graph(arrayGraph);
        System.out.println();
        System.out.println("breadthFirstSearch-Gbig");
        Gbig.breadthFirstSearch();
        System.out.println("\n");
        System.out.println("depthFirstSearch-Gbig");
        Gbig.depthFirstSearch(0);
        System.out.println("\n");

        Set<Integer> setOfVertices = new HashSet<>();
        setOfVertices.add(1);
        setOfVertices.add(2);
        setOfVertices.add(3);
        setOfVertices.add(4);
        setOfVertices.add(5);
        System.out.println("size = " + setOfVertices.size());
        System.out.println("length = " + arrayGraph3.length);


 */


        Graph G4 = new Graph(arrayGraph4);
        System.out.println();
        System.out.println("breadthFirstSearch-G4");
        G4.breadthFirstSearch();
        System.out.println("\n");
        System.out.println("breadthFirstSearch-G4");
        G4.breadthFirstSearch();
        System.out.println("\n");
        System.out.println("depthFirstSearch-G4");
        G4.depthFirstSearch(0);
        System.out.println("\n");
        System.out.println("depthFirstSearch-G4");
        G4.depthFirstSearch(0);
        System.out.println("\n");



    }
}