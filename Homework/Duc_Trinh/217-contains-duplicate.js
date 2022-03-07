/**
 * @param {number[]} nums
 * @return {boolean}
 */
 var containsDuplicate = function(nums) {
    const hashmap = {}
    let res = false
    for (let i = 0; i < nums.length; i++) {
        if (hashmap[nums[i]]) {
            hashmap[nums[i]] = hashmap[nums[i]] + 1
        } else {
            hashmap[nums[i]] = 1
        }
    }
    Object.keys(hashmap).forEach((key) => {
        if (hashmap[key] > 1) {
            res = true
        }
    })
    return res
};