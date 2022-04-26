/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function (nums) {
  let nextCorrectPosToSet = 0;
  // set 0s in correct place
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] === 0) {
      const temp = nums[nextCorrectPosToSet];
      nums[nextCorrectPosToSet] = nums[i];
      nums[i] = temp;
      nextCorrectPosToSet = nextCorrectPosToSet + 1;
    }
  }
  // set 1s in correct place
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] === 1) {
      const temp = nums[nextCorrectPosToSet];
      nums[nextCorrectPosToSet] = nums[i];
      nums[i] = temp;
      nextCorrectPosToSet = nextCorrectPosToSet + 1;
    }
  }
};
