/**
 * @param {number[]} nums
 */
var NumArray = function (nums) {
  this.prefixSum = [];
  for (let i = 0; i < nums.length; i++) {
    this.prefixSum.push(nums[i] + (i ? this.prefixSum[i - 1] : 0));
  }
};

/**
 * @param {number} left
 * @param {number} right
 * @return {number}
 */
NumArray.prototype.sumRange = function (left, right) {
  return this.prefixSum[right] - (left ? this.prefixSum[left - 1] : 0);
};

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */
