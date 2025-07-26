package tree.representation;

public class TreeNode {
    // value of the node
    public int val;
    // reference of left child
    public TreeNode left;
    // reference of right child
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}