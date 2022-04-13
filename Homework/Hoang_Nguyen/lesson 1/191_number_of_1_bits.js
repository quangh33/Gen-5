/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function (n) {
  let count = 0;
  while (n) {
    count++;
    n &= n - 1; // turn off the right most bit
  }
  return count;
};

/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeightRecur = function (n) {
  return n ? 1 + hammingWeightRecur(n & (n - 1)) : 0;
};
