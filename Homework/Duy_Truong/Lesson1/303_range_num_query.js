/**
 * @param {number[]} nums
 */
var NumArray = function(nums) {
    this.sums = []
    for(let i=0;i<nums.length;i++) {
        this.sums.push(nums[i])
    }
};

/** 
 * @param {number} left 
 * @param {number} right
 * @return {number}
 */
NumArray.prototype.sumRange = function(left, right) {
    let count = 0;
    for(let i=left;i<=right;i++) {
        count += this.sums[i]
    }
    return count
};

/** 
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */