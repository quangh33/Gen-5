/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */

var subarraysDivByK = function(nums, k) {
    let prefix = [nums[0]]
    let count = 0
    let hashMap = {
        0: 1, // why? if prefix[j]  % k === 0 then we need to count it
    }
    // build prefix
    for (let i = 1; i < nums.length; i++) {
        prefix[i] = prefix[i - 1] + nums[i]
    }
    // build hashMap and count
    for (let i = 0; i < prefix.length; i++) {
        let remainder = prefix[i] % k
        if (remainder < 0) remainder = remainder + k
        if (hashMap[remainder]) {
            count += hashMap[remainder]
            hashMap[remainder] = hashMap[remainder] + 1
        } else {
            hashMap[remainder] = 1
        }
    }
    return count
};
