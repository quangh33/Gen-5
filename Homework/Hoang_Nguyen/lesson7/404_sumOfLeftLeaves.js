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
var sumOfLeftLeaves = function (root) {
  if (!root) return 0;
  let result = 0;
  if (root.left && !root.left.left && !root.left.right) {
    result += root.left.val;
  }
  return result + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
};
