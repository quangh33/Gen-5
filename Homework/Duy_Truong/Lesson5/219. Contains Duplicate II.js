/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var containsNearbyDuplicate = function(nums, k) {
    let map = new Map; let max = 0
    for(let i=0;i<nums.length;i++) {
        if(!map.has(nums[i])) {
            map.set(nums[i], i)
        } else { 
            if(i - map.get(nums[i]) <= k)
                return true
            else
                map.set(nums[i], i)
        }
    }
    return false
};