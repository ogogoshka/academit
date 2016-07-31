public class DepthFirstSearch {

    public static void visit(TreeNode node) {
        System.out.print(node.getValue() + " ");
        for (int i = 0; i < node.childrenArray.length; i++) {
            visit(node.childrenArray[i]);
        }
    }

/*
    public static boolean depthFirstSearch(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print("Checking node " + node.getValue());
            if (isGoal(node)) {
                System.out.println("\nFound goal node " + node.getValue());
                return true;
            }
            stack.addAll(node.children);
            dump(stack);
        }
        return false;
    }
 */


}