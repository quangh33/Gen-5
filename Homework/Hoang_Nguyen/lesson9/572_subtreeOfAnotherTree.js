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
 * @param {TreeNode} subRoot
 * @return {boolean}
 */
var isSubtree = function (root, subRoot) {
  function compareNodes(node, subNode) {
    if (!node && !subNode) return true;
    if (!node || !subNode) return false;
    if (node.val !== subNode.val) return false;
    return (
      compareNodes(node.left, subNode.left) &&
      compareNodes(node.right, subNode.right)
    );
  }

  if (!root) return false;
  if (compareNodes(root, subRoot)) {
    return true;
  }
  return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
};
