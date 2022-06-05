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
var rob = function (root) {
  return Math.max(...dfs(root));

  // return [rob node, not rob node]
  function dfs(node) {
    if (!node) return [0, 0];

    const [rotSumLeft, notRobSumLeft] = dfs(node.left);
    const [rotSumRight, notRobSumRight] = dfs(node.right);

    // option 1: rob this node and its grandchildren
    let robSum = node.val + notRobSumLeft + notRobSumRight;

    // option 2: rob this node's children
    let notRobSum = rotSumLeft + rotSumRight;

    // rob option is the optimal option between 2 options
    robSum = Math.max(robSum, notRobSum);

    return [robSum, notRobSum];
  }
};
