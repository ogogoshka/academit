import java.util.NoSuchElementException;

public class DepthFirstSearch {

    public static void visit(TreeNode node) {
        if (node == null) {
            throw new NoSuchElementException("дерево пустое");
        }
        System.out.print(node.getValue() + " ");
        for (TreeNode child : node.childrenArray) {
            visit(child);
        }
    }

}