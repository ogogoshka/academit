import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BreadthFirstSearch {

    public static void visit(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                System.out.print(node.getValue() + " ");
                for (int i = 0; i < node.childrenArray.length; i++) {
                    if (node.childrenArray[i] != null) {
                        queue.add(node.childrenArray[i]);
                    }
                }
            }
        } else {
            throw new NoSuchElementException("");
        }
    }




}