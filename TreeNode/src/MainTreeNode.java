public class MainTreeNode {
    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(11);
        TreeNode n2 = new TreeNode(22);
        TreeNode n3 = new TreeNode(33);
        TreeNode n4 = new TreeNode(44);
        TreeNode n5 = new TreeNode(55);
        TreeNode n6 = new TreeNode(66);
        TreeNode n7 = new TreeNode(77);
        TreeNode n8 = new TreeNode(88);
        TreeNode n99 = new TreeNode(101);

        TreeNode n101 = new TreeNode(1010);
        TreeNode n102 = new TreeNode(1020);

        TreeNode n9 = new TreeNode(9, new TreeNode[]{n1, n2});
        TreeNode n10 = new TreeNode(10, new TreeNode[]{n3, n4, n5});

        TreeNode root = new TreeNode(27, new TreeNode[]{n9, n10});

        TreeNode n11 = new TreeNode(10, new TreeNode[]{n6, n6, n8, n99});
        TreeNode n12 = new TreeNode(10, new TreeNode[]{n7});
        TreeNode n13 = new TreeNode(10, new TreeNode[]{n101, n102});

        //BreadthFirstSearch i = new BreadthFirstSearch();
        System.out.println("Breadth First Search : ");
        BreadthFirstSearch.visit(root);

        System.out.println();
        //visit(root);


        TreeNode r2 = new TreeNode(20);
        TreeNode r3 = new TreeNode(25);
        TreeNode r4 = new TreeNode(30);
        TreeNode r5 = new TreeNode(35);

        TreeNode r8 = new TreeNode(10, new TreeNode[]{r2, r3});
        TreeNode r9 = new TreeNode(15, new TreeNode[]{r4, r5});
        TreeNode root2 = new TreeNode(5, new TreeNode[]{r8, r9});

        System.out.println("Breadth First Search : ");
        BreadthFirstSearch.visit(root2);
        System.out.println();

        System.out.println("Depth First Search : ");
        DepthFirstSearch.visit(root2);

    }
}