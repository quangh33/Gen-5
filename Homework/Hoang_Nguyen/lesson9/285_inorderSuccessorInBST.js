/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @return {TreeNode}
 */
var inorderSuccessor = function (root, p) {
  let ans = null;

  while (root) {
    if (root.val <= p.val) {
      root = root.right;
    } else {
      ans = root;
      root = root.left;
    }
  }

  return ans;
};
