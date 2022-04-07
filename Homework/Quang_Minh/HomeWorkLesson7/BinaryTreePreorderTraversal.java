package HomeWorkLesson7;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return result;
    }
    public void dfs(TreeNode node){
        if(node == null) return;
        result.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}
