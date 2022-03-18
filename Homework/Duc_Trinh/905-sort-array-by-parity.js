/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortArrayByParity = function (nums) {
  let correctEvenNumberPos = 0;
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] % 2 === 0) {
      const temp = nums[correctEvenNumberPos];
      nums[correctEvenNumberPos] = nums[i];
      nums[i] = temp;
      correctEvenNumberPos = correctEvenNumberPos + 1;
    }
  }
  return nums;
};
