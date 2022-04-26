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

const notRobCache = new Map()
const robCache = new Map()

const getMaxSumOfCurrentNode = (node, isRobbing=true) => {
    if (!node) return 0
    if (isRobbing) {
      if (robCache.has(node)) return robCache.get(node)
      const maxRobVal =  node.val + getMaxSumOfCurrentNode(node.left, false) + getMaxSumOfCurrentNode(node.right, false)
      robCache.set(node, maxRobVal)
      return maxRobVal
    } else {
      if (notRobCache.has(node)) return notRobCache.get(node)
      const maxNotRobVal = Math.max(getMaxSumOfCurrentNode(node.left, false), getMaxSumOfCurrentNode(node.left)) + Math.max(getMaxSumOfCurrentNode(node.right, false), getMaxSumOfCurrentNode(node.right))
      notRobCache.set(node, maxNotRobVal)
      return maxNotRobVal
    }
}

var rob = function(root) {
    return Math.max(getMaxSumOfCurrentNode(root, false), getMaxSumOfCurrentNode(root))
};
