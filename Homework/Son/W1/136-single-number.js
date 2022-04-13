/**
 * @param {number[]} nums
 * @return {number}
 */
 var singleNumber = function(nums) {
    let numSet = new Set();
    for (let num of nums) {
        if (!numSet.has(num)) numSet.add(num)
        else if (numSet.has(num)) numSet.delete(num)
    }
    return numSet.values().next().value;
};