/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */

var merge = function(nums1, m, nums2, n) {
    let nums1ReadPointer = 0
    let nums2ReadPointer = 0
    let writePointer = 0
    const nums1Copy = []
    for (let i = 0; i < m; i++) {
        nums1Copy[i] = nums1[i]
    }
    while (writePointer < nums1.length) {
        if ((nums1Copy[nums1ReadPointer] <= nums2[nums2ReadPointer] && nums1ReadPointer < m) || nums2ReadPointer >= n) {
            nums1[writePointer] = nums1Copy[nums1ReadPointer]
            nums1ReadPointer++
        } else {
            nums1[writePointer] = nums2[nums2ReadPointer]
            nums2ReadPointer++
        }
        writePointer++
    }
    return nums1
};