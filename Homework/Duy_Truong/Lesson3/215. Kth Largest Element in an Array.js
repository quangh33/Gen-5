/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function(nums, k) {
    if(nums.length == 1) return nums[0]
    nums.sort((a,b) => b-a); 
    return nums[k-1]
    //if distinct element
    // for(let i=0;i<nums.length-1;i++) {
    //     if(nums[i] > nums[i+1])
    //         k--;
    //     if(k == 0)
    //         return nums[i]
    // }
};