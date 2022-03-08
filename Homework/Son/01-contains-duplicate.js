/**
 * @param {number[]} nums
 * @return {boolean}
 */
 var containsDuplicate = function(nums) {
    let temp = new Set()
    for (let i of nums) {
        if (!temp.has(i)) temp.add(i);
        else return true;
    }
    return false;
};