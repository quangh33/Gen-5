/**
 * @param {number[]} nums
 * @return {number}
 */
 var singleNumber = function(nums) {
    let numStack = new Set();
    for (let num of nums) {
        if (!numStack.has(num)) numStack.add(num)
        else if (numStack.has(num)) numStack.delete(num)
    }
    return numStack.values().next().value;
};