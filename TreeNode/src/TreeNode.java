public class TreeNode {
    public TreeNode[] childrenArray = new TreeNode[]{};
    private int value;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode[] childrenArray) {
        this.value = value;
        this.childrenArray = childrenArray;
    }

    public int getValue() {
        return value;
    }

}