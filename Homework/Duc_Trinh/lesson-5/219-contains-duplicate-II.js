/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var containsNearbyDuplicate = function(arr, k) {
    const hm = {}
    for (let i = 0; i < arr.length; i++) {
        if (i >= k + 1) {
            hm[arr[i - k - 1]] = false
        }
        if (hm[arr[i]]) return true
        hm[arr[i]] = true
    }
    return false
};
