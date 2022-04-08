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
var longestZigZag = function (root) {
  let ans = 0;
  dfs(root);
  return ans;

  // return the path in left and right nodes as [left, right]
  function dfs(node) {
    if (!node) return [0, 0];
    let left = 0;
    if (node.left) {
      const [_, rightNode] = dfs(node.left);
      left = rightNode + 1; // add up right side to left side
    }
    let right = 0;
    if (node.right) {
      const [leftNode, _] = dfs(node.right);
      right = leftNode + 1; // add up left side to right side
    }
    ans = Math.max(ans, left, right);
    return [left, right];
  }
};
