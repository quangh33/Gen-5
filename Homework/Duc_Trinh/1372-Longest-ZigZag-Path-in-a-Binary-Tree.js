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

 const getLongestZigZag = (node, dir, answer) => {
    if (!node) return 0
    const left = getLongestZigZag(node.left, 'left', answer)
    const right = getLongestZigZag(node.right, 'right', answer)
    answer.longest = Math.max(answer.longest, Math.max(left, right) )
    return dir === 'left' ? 1 + right : 1 + left
}
var longestZigZag = function(root) {
  const answer = {
      longest: 0
  }
  if (root.left) {getLongestZigZag(root, 'left', answer)}
  if (root.right) {getLongestZigZag(root, 'right', answer)}
  return answer.longest
};
