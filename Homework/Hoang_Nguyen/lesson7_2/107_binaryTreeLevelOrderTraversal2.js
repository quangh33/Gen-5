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
 * @return {number[][]}
 */
var levelOrderBottom = function (root) {
  const result = [];
  const queue = [];
  queue.unshift(root);

  while (queue.length) {
    const currentSize = queue.length;
    const currentNodes = [];
    for (let i = 0; i < currentSize; i++) {
      const node = queue.pop();
      if (!node) continue;

      currentNodes.push(node.val);

      queue.unshift(node.left);
      queue.unshift(node.right);
    }
    if (currentNodes.length) {
      result.unshift(currentNodes);
    }
  }

  return result;
};
