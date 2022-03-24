/**
 * @param {number[]} nums
 */
var NumArray = function (nums) {
  this.sum = [];
  var sum = 0;

  for (let i = 0; i < nums.length; i++) {
    sum += nums[i];
    this.sum.push(sum);
  }
};

/**
 * @param {number} left
 * @param {number} right
 * @return {number}
 */
NumArray.prototype.sumRange = function (left, right) {
  return this.sum[right] - (left != 0 ? this.sum[left - 1] : 0);
};

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */
