import ru.academit.novikov.binarytree.BinaryTree;

public class MainBinaryTree {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        BinaryTree bst = new BinaryTree();

        binaryTree.add(3);
        binaryTree.add(12);
        binaryTree.add(1);
        binaryTree.add(6);
        binaryTree.add(9);
        binaryTree.add(22);
        binaryTree.add(55);
        binaryTree.add(33);

        System.out.println(binaryTree.search(33));
        BinaryTree.printFindMin(binaryTree);
        BinaryTree.printMin(binaryTree);


        bst.add(5);
        bst.add(2);
        bst.add(18);
        bst.add(-4);
        bst.add(3);

        System.out.println(bst.search(-111));
        System.out.println(bst.search(5));

        bst.delete(5);
        System.out.println(bst.search(5));



        BinaryTree bst3 = new BinaryTree();
        bst3.insert(5);
        bst3.insert(2);
        bst3.insert(18);
        bst3.insert(-4);
        bst3.insert(3);

        System.out.println(bst3.search(33));
        System.out.println(bst3.search(5));
        BinaryTree.printFindMin(bst3);


        //System.out.println(bst3.delete(5));
        //System.out.println(bst3.search(5));

    }
}