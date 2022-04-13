/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function (nums) {
  // move all non zero elements to pos
  let pos = 0;
  for (let i = 0; i < nums.length; i++) {
    if (nums[i]) {
      // swap i & pos
      [nums[i], nums[pos]] = [nums[pos], nums[i]];
      pos++;
    }
  }
};
