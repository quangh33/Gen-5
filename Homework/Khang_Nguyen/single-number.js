/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    return nums.reduce((xorResult, num) => num ^ xorResult)
};
// Time complex: O(n)
// Space complex: O(1)
// Another solution: hashmap