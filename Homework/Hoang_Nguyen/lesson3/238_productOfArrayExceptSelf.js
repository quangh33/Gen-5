/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function (nums) {
  const result = [];
  // calculate reverse prefix products
  result[nums.length - 1] = nums[nums.length - 1];
  for (let i = nums.length - 2; i >= 0; i--) {
    result[i] = nums[i] * result[i + 1];
  }
  let prefixProduct = 1;
  let i = 0;
  for (i = 0; i < nums.length - 1; i++) {
    result[i] = prefixProduct * result[i + 1];
    prefixProduct *= nums[i];
  }
  result[i] = prefixProduct;
  return result;
};
