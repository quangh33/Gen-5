/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
    let duplicateObj = {}
    for(let i=0;i<nums.length;i++) {
        if(duplicateObj.hasOwnProperty(nums[i]))
            return true;
        duplicateObj[nums[i]] = 1;
    }
    return false
};