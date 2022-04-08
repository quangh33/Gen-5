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
var findFrequentTreeSum = function (root) {
  // sum => freq
  const freqMap = new Map();
  let maxFreq = 0;

  function sumSubtree(node) {
    if (!node) return 0;
    const sum = sumSubtree(node.left) + sumSubtree(node.right) + node.val;
    const freq = (freqMap.get(sum) || 0) + 1;
    if (freq > maxFreq) {
      maxFreq = freq;
    }
    freqMap.set(sum, freq);
    return sum;
  }

  sumSubtree(root);

  let result = [];
  for (const [sum, freq] of freqMap) {
    if (freq === maxFreq) {
      result.push(sum);
    }
  }
  return result;
};
