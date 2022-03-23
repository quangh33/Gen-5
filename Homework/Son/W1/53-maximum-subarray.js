/**
 * @param {number[]} nums
 * @return {number}
 */
 var maxSubArray = function(nums) {
    let currentSum = nums[0]
    let maxSum = nums[0]
    let comparisonArray = []
    for (let i = 1; i <nums.length; i++) {
        let num = nums[i];
        currentSum = Math.max(num, currentSum + num)
        maxSum = Math.max(maxSum, currentSum)
    }
      return maxSum;
  };

//   https://leetcode.com/problems/maximum-subarray/