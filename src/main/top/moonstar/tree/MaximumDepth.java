package top.moonstar.tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

}

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        return leftMax > rightMax ? leftMax + 1 : rightMax + 1;
    }

}
