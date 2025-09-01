package bst.representation;

public class BinarySearchTreeMain {
    public static TreeNode buildBalancedBST() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        return root;
    }

    public static TreeNode buildUnbalancedLeftBST() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        root.left.left.left.left = new TreeNode(1);

        return root;
    }

    public static Node buildBST() {
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);

        root.left.left = new Node(2);
        root.left.right = new Node(6);

        root.right.left = new Node(10);
        root.right.right = new Node(14);

        return root;
    }


    public static void main(String[] args) {
    }
}