package top.moonstar.tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        levelTraverse(root, res, 0);
        return res;
    }

    public void levelTraverse(TreeNode root, List<Integer> res, int level) {
        if (root == null) {
            return;
        }

        if (res.size() <= level) {
            res.add(root.val);
        } else {
            // do nothing
        }

        levelTraverse(root.right, res, level + 1);
        levelTraverse(root.left, res, level + 1);
    }
}
