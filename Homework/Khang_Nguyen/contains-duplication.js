/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
    const frequency = {}
    return nums.some(num => {
        if (!frequency[num]) {
            frequency[num] = 1
            return false
        } else {
            return true
        }
    })
};