/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraysDivByK = function (nums, k) {
  let prefixSum = 0;

  // stores remainders of modulo operation with their frequencies
  // 0th index: 1 - for increasing result when there is a first divisible by k sum
  const remainders = [1];

  let result = 0;
  for (let i = 0; i < nums.length; i++) {
    prefixSum += nums[i];

    let remainder = prefixSum % k;
    // only keeps positive remainders
    if (remainder < 0) {
      remainder += k;
    }

    if (remainders[remainder]) {
      result += remainders[remainder];
      remainders[remainder]++;
    } else {
      remainders[remainder] = 1;
    }
  }
  return result;
};
