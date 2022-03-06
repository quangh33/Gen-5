/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
    const dict = {}
    return nums.some(num => {
        if (!dict[num]) {
            dict[num] = 1
            return false
        } else {
            return true
        }
    })
};