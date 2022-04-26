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
 * @return {boolean}
 */
var isValidBST = function (root) {
  let prev;
  return inorder(root);

  function inorder(node) {
    if (!node) return true;

    const left = inorder(node.left);

    if (prev !== undefined && prev >= node.val) {
      return false;
    }
    prev = node.val;

    const right = inorder(node.right);

    return left && right;
  }
};

var isValidBST = function (root) {
  return checkVal(root, null, null);

  function checkVal(node, min, max) {
    if (!node) return true;

    if (min !== null && node.val < min) {
      return false;
    }
    if (max !== null && node.val > max) {
      return false;
    }

    return (
      checkVal(node.left, min, node.val - 1) &&
      checkVal(node.right, node.val + 1, max)
    );
  }
};
