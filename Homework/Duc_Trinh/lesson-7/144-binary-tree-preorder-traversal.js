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
 * @return {number[]}
 */
// Pre-Order: root -> left -> right
var preorderTraversal = function(root) {
    const out = []
    const stack = [root]
    while (stack.length > 0) {
        const cur = stack.pop()
        if (!cur) continue;
        out.push(cur.val)
        if (cur.right) stack.push(cur.right)
        if (cur.left) stack.push(cur.left)
    }
    return out
};