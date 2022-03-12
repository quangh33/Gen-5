/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortArrayByParityII = function (nums) {
  let indexStack = [];
  for (let i = 0; i < nums.length; i++) {
    // if not satisfied the condition
    if ((i & 1) !== (nums[i] & 1)) {
      // if empty stack or cannot swap with previous index (both odd or even)
      if (
        !indexStack.length ||
        (indexStack[indexStack.length - 1] & 1) === (i & 1)
      ) {
        indexStack.push(i);
      } else {
        // only swap if 1 index is odd and other is even
        const j = indexStack.pop();
        // swap i & j
        [nums[i], nums[j]] = [nums[j], nums[i]];
      }
    }
  }
  return nums;
};
