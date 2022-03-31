/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var maxSlidingWindow = function (nums, k) {
  // stores index of elements in nums array
  const indexQueue = [];
  const result = [];
  for (let i = 0; i < nums.length; i++) {
    // remove all elements in queue that are smaller than current element
    while (
      indexQueue.length &&
      nums[indexQueue[indexQueue.length - 1]] < nums[i]
    ) {
      indexQueue.pop();
    }
    indexQueue.push(i);
    // reached the first sliding window
    if (i >= k - 1) {
      // dequeue invalid index in sliding window
      while (indexQueue[0] < i - k + 1) {
        indexQueue.shift();
      }
      result.push(nums[indexQueue[0]]);
    }
  }
  return result;
};
