/**
 * @param {number[]} nums
 * @return {number[]}
 */
var frequencySort = function(nums) {
    let map = new Map; let res = []; let sortArr = [];
    for(let i=0;i<nums.length;i++) {
        if(!map.has(nums[i]))
            map.set(nums[i], 1)
        else
            map.set(nums[i], map.get(nums[i]) + 1)
    }
    nums.sort((a,b) => map.get(a) - map.get(b) || b-a)
    return nums
};