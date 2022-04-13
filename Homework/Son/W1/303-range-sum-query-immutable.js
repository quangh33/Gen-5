// Add data and cache to prototype 
/**
 * @param {number[]} nums
 */
 var NumArray = function(nums) {
    data = nums;
    NumArray.cache = {}
    
    let sum = 0
    for (let i = 0; i < data.length; i++) {
        sum += data[i]
        NumArray.cache[i] = sum
    }
};

/** 
 * @param {number} left 
 * @param {number} right
 * @return {number}
 */
NumArray.prototype.cache = undefined;
NumArray.prototype.data = undefined;
NumArray.prototype.sumRange = function(left, right) {
    let cache = NumArray.cache;
    
	// Edge case if left === 0 or the input is [0,0]
    if (left === 0 || right === 0) {
        return cache[right]
    }
    
    return cache[right] - cache[left - 1]
};
/** 
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */

// Use bulit in method for NumArray 
/**
 * @param {number[]} nums
 */
 var NumArray = function(nums) {
    this.preNums = new Array(nums.length+1).fill(0);
    for (let i = 1; i < this.preNums.length; i++) {
    this.preNums[i] = this.preNums[i - 1] + nums[i - 1];
    }
};

/** 
 * @param {number} left 
 * @param {number} right
 * @return {number}
 */

NumArray.prototype.sumRange = function(left, right) {
    return this.preNums[right + 1] - this.preNums[left];
};
/** 
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */

//  https://leetcode.com/problems/range-sum-query-immutable/