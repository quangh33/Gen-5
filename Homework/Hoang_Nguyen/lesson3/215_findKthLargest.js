function partition(nums, low, high) {
  const pivotIndex = Math.floor(Math.random() * (high - low + 1)) + low;
  // swap random pivot to the end
  [nums[pivotIndex], nums[high]] = [nums[high], nums[pivotIndex]];

  const pivot = nums[high];
  let j = low - 1;
  for (let i = low; i < high; i++) {
    if (nums[i] > pivot) {
      j++;
      // swap i & j
      [nums[i], nums[j]] = [nums[j], nums[i]];
    }
  }
  j++;
  // swap j & high
  [nums[high], nums[j]] = [nums[j], nums[high]];
  return j;
}

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function (nums, k) {
  let low = 0;
  let high = nums.length - 1;
  while (low <= high) {
    let p = partition(nums, low, high);
    if (p === k - 1) {
      break;
    } else if (p > k - 1) {
      high = p - 1;
    } else {
      low = p + 1;
    }
  }
  return nums[k - 1];
};
