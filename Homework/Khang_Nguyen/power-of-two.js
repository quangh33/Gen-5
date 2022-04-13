/**
 * @param {number} n
 * @return {boolean}
 */
 var isPowerOfTwo = function(n) {
    if (n <= 0) return false
    return (n & (n - 1)) === 0
};

// Time: O(1)
// Space: O(1)