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

// insight: diameter of node A = max Len node A'left + max Len node A'right
// max Len node A'left = dfs from node A to leaf

const getMaxDepth = (node, dummyObjPassingByRef) => {
    if (!node) return 0
    let maxLeft = getMaxDepth(node.left, dummyObjPassingByRef)
    let maxRight = getMaxDepth(node.right, dummyObjPassingByRef)
    dummyObjPassingByRef.diameter = Math.max(dummyObjPassingByRef.diameter, maxLeft + maxRight)
    return Math.max(maxLeft, maxRight) + 1
}

var diameterOfBinaryTree = function(root) {
    let dummyObjPassingByRef = {diameter: 0}
    getMaxDepth(root, dummyObjPassingByRef)
    return dummyObjPassingByRef.diameter
};

