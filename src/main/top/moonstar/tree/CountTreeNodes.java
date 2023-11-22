package top.moonstar.tree;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/submissions/
 */
public class CountTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getTreeHeight(root.left);
        int rightHeight = getTreeHeight(root.right);

        if (leftHeight == rightHeight) {
            return (int) Math.pow(2, leftHeight) + countNodes(root.right);
        } else {
            return (int) Math.pow(2, rightHeight) + countNodes(root.left);
        }
    }

    private int getTreeHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.left;
            height++;
        }
        return height;
    }
}
