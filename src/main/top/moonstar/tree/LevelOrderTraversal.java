package top.moonstar.tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderHelper(root, res, 0);
        return res;
    }

    private void levelOrderHelper(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }

        List<Integer> levelRes = null;
        if (res.size() <= level) {
            levelRes = new ArrayList<>();
            res.add(level, levelRes);
        } else {
            levelRes = res.get(level);
        }

        levelRes.add(root.val);
        levelOrderHelper(root.left, res, level + 1);
        levelOrderHelper(root.right, res, level + 1);
    }
}
