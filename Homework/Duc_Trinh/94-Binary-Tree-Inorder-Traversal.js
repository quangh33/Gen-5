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
var inorderTraversal = function(root) {
    // Recursive solution
    // const out = []
    // const traverse = (node, out) => {
    //     if (!node) return
    //     if (node.left) traverse(node.left, out)
    //     out.push(node.val)
    //     if (node.right) traverse(node.right, out)   
    // }
    // traverse(root, out)
    // return out
    
    if (!root) return []
    const stack = [root]
    let curr = root
    let res = []
    while (stack.length > 0) {
        while (curr && curr.left) {
            stack.push(curr.left)
            curr = curr.left
        }
        curr = stack.pop()
        if (curr) {
            res.push(curr.val)
            stack.push(curr.right)
            curr = curr.right
        }
    }
    return res
};
