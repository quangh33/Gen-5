package HomeWorkLesson7;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return result;
    }
    public void dfs(TreeNode node){
        if(node == null) return;
        dfs(node.left);
        result.add(node.val);
        dfs(node.right);
    }
}
