/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
    if (n === 0) return 0;
    return 1 + hammingWeight(n&(n-1))
};
// time: O(log2 of n)
// space: O(1)