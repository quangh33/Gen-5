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

var sumOfLeftLeaves = function(root) {
    const stack = [root]
    let sum = 0
    while (stack.length) {
        const next = stack.pop()
        if (next.left && !next.left.left && !next.left.right) {
            sum += next.left.val
        }
        if (next.left) stack.push(next.left)
        if (next.right) stack.push(next.right)
    }
    return sum
  };
