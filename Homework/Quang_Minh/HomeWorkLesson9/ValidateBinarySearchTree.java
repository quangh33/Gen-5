package HomeWorkLesson9;

import HomeWorkLesson7.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    public boolean isValid(TreeNode u, TreeNode min, TreeNode max) {
        if (u == null) return true;
        if (max != null && u.val >= max.val) return false;
        if (min != null && u.val <= min.val) return false;
        return isValid(u.left, min, u) && isValid(u.right, u ,max);
    }
}
