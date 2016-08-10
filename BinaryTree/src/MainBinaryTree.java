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
        //BinaryTree.printFindMin(binaryTree);
        //BinaryTree.printMin(binaryTree);


        bst.add(5);
        bst.add(2);
        bst.add(18);
        bst.add(-4);
        bst.add(3);

        System.out.println(bst.search(-111));
        System.out.println(bst.search(5));

        bst.add(-111);
        System.out.println(bst.search(-111));

/*
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
 */

        BinaryTree bst2 = new BinaryTree();
        bst2.add(5);
        bst2.add(2);
        bst2.add(6);
        bst2.add(3);


        BinaryTree bst3 = new BinaryTree();
        bst3.add(1);
        bst3.add(5);
        bst3.add(2);
        bst3.add(6);
        bst3.add(3);
        bst3.add(-51);
        bst3.add(4);

        System.out.println("bst3");

        System.out.println(bst3.search(1111));
        System.out.println(bst3.search(5));

        bst3.add(1111);
        System.out.println(bst3.search(1111));




        BinaryTree bst4 = new BinaryTree();
        bst4.add(9);
        bst4.add(7);
        bst4.add(5);
        bst4.add(8);
        bst4.add(15);
        bst4.add(11);
        bst4.add(17);



        System.out.println(bst4.search(5));

        bst4.delete(9);
        System.out.println(bst4.search(9));



        BinaryTree bst5 = new BinaryTree();
        bst5.add(9);
        //bst4.add(7);
        //bst4.add(5);
        //bst4.add(8);
        bst5.add(15);
        bst5.add(11);
        bst5.add(17);
        bst5.add(16);
        bst5.add(22);



        bst5.delete(9);
        System.out.println(bst5.search(9));

    }
}
