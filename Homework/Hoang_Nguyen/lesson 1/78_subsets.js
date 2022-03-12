/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function (nums) {
  let result = [[]];

  if (nums.length === 1) {
    result.push([nums[0]]);
  } else {
    let subResult = subsets(nums.slice(1));
    for (let arr of subResult) {
      if (arr.length) {
        // add non empty array to result
        result.push([...arr]);
      }
      result.push([...arr, nums[0]]); // add merged array to result
    }
  }

  return result;
};

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsBit = function (nums) {
  const n = nums.length;
  const result = [];
  for (let i = 0; i < Math.pow(2, n); i++) {
    const subset = [];
    let num = i;
    let pos = 0;
    while (num) {
      // right shift num by 1 to find bit 1's positions until num is 0
      if (num & 1) {
        subset.push(nums[pos]);
      }
      pos++;
      num >>= 1;
    }
    result.push(subset);
  }
  return result;
};
