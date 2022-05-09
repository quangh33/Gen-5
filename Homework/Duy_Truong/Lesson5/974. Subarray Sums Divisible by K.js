/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraysDivByK = function(nums, k) {
    let prefixSum = 0, m = new Map, count = 0;
    m.set(0,1);
    for (let i = 0; i < nums.length; i++) {
        prefixSum = (prefixSum + nums[i]) % k;
        if (prefixSum < 0) prefixSum += k;
        if (m.has(prefixSum)) count += m.get(prefixSum);
        m.set(prefixSum, m.get(prefixSum) + 1 || 1);
    }
    return count;
};