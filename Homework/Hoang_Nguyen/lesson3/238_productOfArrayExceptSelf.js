/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function (nums) {
  const reversePrefixProducts = [];
  reversePrefixProducts[nums.length - 1] = nums[nums.length - 1];
  for (let i = nums.length - 2; i >= 0; i--) {
    reversePrefixProducts[i] = nums[i] * reversePrefixProducts[i + 1];
  }
  const result = [];
  let prefixProduct = 1;
  let i = 0;
  for (i = 0; i < nums.length - 1; i++) {
    result[i] = prefixProduct * reversePrefixProducts[i + 1];
    prefixProduct *= nums[i];
  }
  result[i] = prefixProduct;
  return result;
};
