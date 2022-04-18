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
var findBottomLeftValue = function (root) {
  const queue = [];
  queue.unshift(root);
  let node;

  while (queue.length) {
    node = queue.pop();
    if (node) {
      if (node.right) {
        queue.unshift(node.right);
      }
      if (node.left) {
        queue.unshift(node.left);
      }
    }
  }
  return node.val;
};
