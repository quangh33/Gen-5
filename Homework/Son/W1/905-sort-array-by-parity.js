/**
 * @param {number[]} nums
 * @return {number[]}
 */
 var sortArrayByParity = function(nums) {
    let start = 0;
    let end = nums.length - 1;
    while (start !== end) {
        if (nums[start] % 2 === 0) start++;
        else if (nums[end] % 2 === 1) end--;
        if (nums[start] % 2 === 1 && nums[end] % 2 === 0) {
            let temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
        }
    }
    return nums;
};

// https://leetcode.com/problems/sort-array-by-parity/