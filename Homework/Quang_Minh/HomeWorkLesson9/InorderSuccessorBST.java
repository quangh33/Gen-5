package HomeWorkLesson9;

import HomeWorkLesson7.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderSuccessorBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> listNodeAfterInorder = new ArrayList<>();
        inorderTraverse(root, listNodeAfterInorder);
        for (int i = 0; i < listNodeAfterInorder.size(); i++) {
            if (listNodeAfterInorder.get(i).val == p.val && i < listNodeAfterInorder.size() - 1) {
                return listNodeAfterInorder.get(i + 1);
            }
        }
        return null;
    }

    private void inorderTraverse(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        inorderTraverse(root.left, list);
        list.add(root);
        inorderTraverse(root.right, list);
    }
}
