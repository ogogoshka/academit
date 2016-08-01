import java.util.NoSuchElementException;

public class DepthFirstSearch {

    public static void visit(TreeNode node) {
        if (node == null) {
            throw new NoSuchElementException("дерево пустое");
        }

        System.out.print(node.getValue() + " ");
        for (int i = 0; i < node.childrenArray.length; i++) {
            visit(node.childrenArray[i]);
        }
    }

}