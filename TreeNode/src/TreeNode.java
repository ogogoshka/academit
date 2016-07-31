import java.util.ArrayList;

public class TreeNode {
    public TreeNode[] childrenArray = new TreeNode[]{};
    public ArrayList childrenList = new ArrayList();
    private int value;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode[] childrenArray) {
        this.value = value;
        this.childrenArray = childrenArray;
    }

    public TreeNode(int value, ArrayList childrenList) {
        this.value = value;
        this.childrenList = childrenList;
    }

    public int getValue() {
        return value;
    }
}