/**
 * @param {number[]} nums
 * @return {number[]}
 */

var sortArrayByParityII = function (nums) {
  let nextOutOfOrderPos = 0;
  for (let i = 0; i < nums.length; i++) {
    if (
      (i % 2 === 0 && nums[i] % 2 !== 0) ||
      (i % 2 !== 0 && nums[i] % 2 === 0)
    ) {
      nextOutOfOrderPos = i;
      break;
    }
  }
  for (let i = 0; i < nums.length; i++) {
    if (nextOutOfOrderPos === i) continue;
    if (
      (i % 2 === 0 && nums[i] % 2 !== 0 && nums[nextOutOfOrderPos] % 2 == 0) ||
      (i % 2 !== 0 && nums[i] % 2 === 0 && nums[nextOutOfOrderPos] % 2 != 0)
    ) {
      // swap pos
      const temp = nums[nextOutOfOrderPos];
      nums[nextOutOfOrderPos] = nums[i];
      nums[i] = temp;
      // increment nextOutOfOrderPos
      for (let j = nextOutOfOrderPos; j < nums.length; j++) {
        if (
          (j % 2 === 0 && nums[j] % 2 !== 0) ||
          (j % 2 !== 0 && nums[j] % 2 === 0)
        ) {
          nextOutOfOrderPos = j;
          break;
        }
      }
      i = nextOutOfOrderPos;
    }
  }
  return nums;
};
