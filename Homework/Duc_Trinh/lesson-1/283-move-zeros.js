/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function (nums) {
  let correctIndex = 0;
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] !== 0) {
      nums[correctIndex] = nums[i];
      correctIndex = correctIndex + 1;
    }
  }
  for (let i = correctIndex; i < nums.length; i++) {
    nums[i] = 0;
  }
};
