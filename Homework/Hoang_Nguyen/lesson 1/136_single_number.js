/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function (nums) {
  return nums.reduce((prevVal, curVal) => prevVal ^ curVal, 0);
};
