package top.moonstar.tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

}

public class ValidateBinarySearchTree {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        traverse(root, nodes);

        for (int i = 0; i < nodes.size() - 1; i++) {
            if (nodes.get(i) >= nodes.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }

}