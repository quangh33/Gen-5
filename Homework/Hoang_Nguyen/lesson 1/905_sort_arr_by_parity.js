/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortArrayByParity = function (nums) {
  let pos = 0;
  for (let i = 0; i < nums.length; i++) {
    if (!(nums[i] & 1)) {
      // swap i & pos
      [nums[pos], nums[i]] = [nums[i], nums[pos]];
      pos++;
    }
  }
  return nums;
};
