/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
    let arr = Array.from(new Set(nums))
    return arr.length != nums.length
};