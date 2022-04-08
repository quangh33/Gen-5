/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var longestUnivaluePath = function (root) {
  let maxPath = 0;
  dfs(root);
  return maxPath;

  function dfs(node) {
    if (!node) return 0;

    const left = dfs(node.left);
    const right = dfs(node.right);
    let maxLeft = 0, // max path from left node
      maxRight = 0; // max path from right node
    if (node.left && node.left.val === node.val) {
      maxLeft = left + 1;
    }
    if (node.right && node.right.val === node.val) {
      maxRight = right + 1;
    }
    maxPath = Math.max(maxPath, maxLeft + maxRight);
    return Math.max(maxLeft, maxRight);
  }
};
