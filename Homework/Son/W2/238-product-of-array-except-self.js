/**
 * @param {number[]} nums
 * @return {number[]}
 */
 var productExceptSelf = function(nums) {
    let left = 1;
    let right = 1; 
    let answer = []
    for (let i = 0; i <nums.length; i++) {
        if (i > 0) {left = left*nums[i-1]}
        answer.push(left)
    }
    for (let i = nums.length -1; i >= 0; i--) {
        if (i < nums.length - 1 ) {right = right*nums[i + 1]}
        answer[i] = answer[i]*right
    }
    return answer
};

// https://leetcode.com/problems/product-of-array-except-self/