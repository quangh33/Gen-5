/**
 * @param {number[]} nums
 */
 var NumArray = function(nums) {
    this.nums = nums
    const len = nums.length
    let tempSum = 0
    this.prefixSum = []
    for (let i = 0; i < len; i++)  {
        tempSum = tempSum + nums[i]
        this.prefixSum.push(tempSum)
    }
};

/** 
 * @param {number} left 
 * @param {number} right
 * @return {number}
 */
NumArray.prototype.sumRange = function(left, right) {
   if (left === 0) return this.prefixSum[right]
   return this.prefixSum[right] - this.prefixSum[left - 1]
};

/** 
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */