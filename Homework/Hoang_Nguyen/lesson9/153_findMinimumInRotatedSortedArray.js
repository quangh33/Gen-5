/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function (nums) {
  let low = 0;
  let high = nums.length - 1;
  while (low <= high) {
    const mid = low + Math.floor((high - low) / 2);
    if (mid + 1 < nums.length && nums[mid + 1] < nums[mid]) {
      return nums[mid + 1];
    } else if (nums[mid] >= nums[low]) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }
  return nums[0];
};
