/**
 * @param {number[]} nums
 */

var NumArray = function (nums) {
  // [-2, -2, 1, -4, -2, -3] -> 1 + 2 + -2
  this.nums = nums;
  this.prefixSum = [];
  for (let i = 0; i < nums.length; i++) {
    if (i === 0) {
      this.prefixSum[i] = nums[0];
    } else {
      this.prefixSum[i] = this.prefixSum[i - 1] + nums[i];
    }
  }
};

/**
 * @param {number} left
 * @param {number} right
 * @return {number}
 */
NumArray.prototype.sumRange = function (left, right) {
  return this.prefixSum[right] - this.prefixSum[left] + this.nums[left];
};

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */
