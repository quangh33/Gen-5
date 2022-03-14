/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function(nums) {
    let m = -1; //m is 0's
    let n = -1; //n is 0's 1's
    let k = -1; //k is 0's 1's 2's
    for(let i=0;i<nums.length;i++) {
        if(nums[i] == 2)
            nums[++k] = 2
        if(nums[i] == 1) {
            nums[++k] = 2
            nums[++n] = 1
        }
        if(nums[i] == 0) {
            nums[++k] = 2
            nums[++n] = 1
            nums[++m] = 0
        }
    }
};