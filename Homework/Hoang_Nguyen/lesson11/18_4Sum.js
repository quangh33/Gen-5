var twoSum = function (nums, left, target) {
  const res = [];
  let right = nums.length - 1;
  while (left < right) {
    const sum = nums[left] + nums[right];
    if (sum < target) {
      left++;
    } else if (sum > target) {
      right--;
    } else {
      res.push([nums[left], nums[right]]);
      // prevent duplication
      while (left < nums.length - 1 && nums[left] === nums[left + 1]) {
        left++;
      }
      while (right > 0 && nums[right] === nums[right - 1]) {
        right--;
      }
      left++;
      right--;
    }
  }
  return res;
};

var threeSum = function (nums, left, target) {
  const res = [];
  for (let i = left; i <= nums.length - 2; i++) {
    // prevent duplication
    if (i > left && nums[i] === nums[i - 1]) {
      continue;
    }
    const twoSumRes = twoSum(nums, i + 1, target - nums[i]);
    twoSumRes.forEach((arr) => res.push([nums[i], ...arr]));
  }
  return res;
};

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
var fourSum = function (nums, target) {
  nums.sort((a, b) => a - b);
  const res = [];
  for (let i = 0; i < nums.length - 3; i++) {
    // prevent duplication
    if (i > 0 && nums[i] === nums[i - 1]) {
      continue;
    }
    const threeSumRes = threeSum(nums, i + 1, target - nums[i]);
    threeSumRes.forEach((arr) => res.push([nums[i], ...arr]));
  }
  return res;
};
