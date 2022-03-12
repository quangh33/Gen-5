/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortArrayByParity = function(nums) {
    let count = 0;
    for(let i=0;i<nums.length;i++) {
        if(nums[i]%2 == 0) {
            let temp = nums[i]
            nums[i] = nums[count]
            nums[count] = temp
            count++
        }
    }
    return nums
};