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

// sum for a Node = left branch + right branch
// traverse thru all nodes, calculate sum & update freqTable

var getSum = function(node, freqMap) {
    if (!node) return 0
    const sum = node.val + getSum(node.left, freqMap) + getSum(node.right, freqMap)
    if (freqMap[sum]) {
        freqMap[sum] = freqMap[sum] + 1
    } else {
        freqMap[sum] = 1
    }
    return sum
};

var findFrequentTreeSum = function(root) {
    const freqMap = {}
    getSum(root, freqMap)
    const maxFreq = Math.max(...Object.values(freqMap))
    let res = []
    Object.keys(freqMap).forEach(sum => {
        if (freqMap[sum] === maxFreq) res.push(sum)
    })
    return res
};
