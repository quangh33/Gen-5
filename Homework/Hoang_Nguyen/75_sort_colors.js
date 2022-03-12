/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function (nums) {
  // move 0 to first positions
  let pos = 0;
  for (let i = 0; i < nums.length; i++) {
    if (!nums[i]) {
      // swap i & pos
      [nums[pos], nums[i]] = [nums[i], nums[pos]];
      pos++;
    }
  }
  // move 1 before 2 with elements from current pos to the end
  for (let i = pos; i < nums.length; i++) {
    if (nums[i] === 1) {
      // swap i & pos
      [nums[pos], nums[i]] = [nums[i], nums[pos]];
      pos++;
    }
  }
};
