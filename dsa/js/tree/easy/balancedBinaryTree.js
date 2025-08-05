/**
 * @author Ripan Baidy
 * @date 05-08-2025
 * 
 * Given a binary tree, determine if it is height-balanced.
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 *
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 */

// TreeNode class to represent a binary tree node
class TreeNode {
    constructor(val, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BalancedBinaryTree {
    height(root) {
        if (root === null) return 0;
        if (root.left === null && root.right === null) return 1;

        // Check if left and right subtrees are balanced, if not balanced, return -1
        const leftDepth = this.height(root.left);
        const rightDepth = this.height(root.right);

        // Tree is not balanced
        if (leftDepth === -1 || rightDepth === -1 || Math.abs(leftDepth - rightDepth) > 1)
            return -1;

        // When the tree is balanced, return the height of the tree
        return 1 + Math.max(leftDepth, rightDepth);
    }

    isBalanced(root) {
        // If the height of the tree is -1, it means the tree is not balanced
        // Otherwise, it is balanced
        return this.height(root) !== -1;
    }
}

// Function to build the sample binary tree
// Input: root = [1,2,2,3,3,null,null,4,4]
function buildTree() {
    const node4_left = new TreeNode(4);
    const node4_right = new TreeNode(4);
    const node3_left = new TreeNode(3, node4_left, node4_right);
    const node3_right = new TreeNode(3);
    const node2_left = new TreeNode(2, node3_left, node3_right);
    const node2_right = new TreeNode(2);
    const root = new TreeNode(1, node2_left, node2_right);

    return root;
}

// Main execution
function main() {
    const obj = new BalancedBinaryTree();

    const root = buildTree();
    const isBalanced = obj.isBalanced(root);
    console.log("Is the binary tree balanced? " + isBalanced);
}

main();