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

// for each node. we can calculate
// 1. longest path through the node (max (left, right))
// 2. longest univalue path in whole tree (longest left + longest right)

var getLongestUnivaluePath = (node, answer) => {
    if (!node) return 0
    // 1. longest path through the node (max (left, right))
    let left = getLongestUnivaluePath(node.left, answer)
    let right = getLongestUnivaluePath(node.right, answer)
    let arrowLeft = 0, arrowRight = 0;
    if (node.left && node.left.val === node.val) {
        arrowLeft = left + 1
    }
    if (node.right && node.right.val === node.val) {
        arrowRight = right + 1
    }
    // 2. longest univalue path in whole tree (longest left + longest right)
    const longestPathAtNode = arrowLeft + arrowRight
    answer.longest = Math.max(answer.longest, longestPathAtNode)
    return Math.max(arrowLeft, arrowRight)
}

var longestUnivaluePath = function(root) {
    const answer = {
        longest: 0
    }
    getLongestUnivaluePath(root, answer)
    return answer.longest
};
