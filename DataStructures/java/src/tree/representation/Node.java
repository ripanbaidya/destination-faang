package tree.representation;

public class Node {
    // value of the node
    public int data;
    // reference of left child
    public Node left;
    // reference of right child
    public Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}