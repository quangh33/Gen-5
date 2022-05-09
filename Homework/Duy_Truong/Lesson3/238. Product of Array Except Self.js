/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
    if(nums.length < 2) return nums[0]
    let res = new Array(nums.length).fill(1)
    for(let i=1;i<nums.length;i++) {
        res[i] = nums[i-1]*res[i-1]
    }
    let lastNum = nums[nums.length-1]
    for(let i=nums.length-2;i>=0;i--) {
        res[i] *= lastNum
        lastNum *= nums[i] 
    }
    
    return res
};