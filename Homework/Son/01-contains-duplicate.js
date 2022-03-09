/**
 * @param {number[]} nums
 * @return {boolean}
 */
 var containsDuplicate = function(nums) {
    let checkDuplicateSet = new Set()
    for (let i of nums) {
        if (!checkDuplicateSet.has(i)) checkDuplicateSet.add(i);
        else return true;
    }
    return false;
};