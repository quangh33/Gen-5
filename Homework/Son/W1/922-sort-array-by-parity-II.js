/**
 * @param {number[]} nums
 * @return {number[]}
 */
 var sortArrayByParityII = function(nums) {
    let i = 0;
    let j = 1;
    while (i < nums.length -1 || j < nums.length -1 ) {
        if (nums[i] % 2 === 0) {i = i + 2;}
        if (nums[j] % 2 === 1) j+=2;
        if (nums[i] % 2 === 1 && nums[j] % 2 === 0) {
            let temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i+=2;
            j+=2;
        }
    }
    return nums;
};

// https://leetcode.com/problems/sort-array-by-parity-ii/