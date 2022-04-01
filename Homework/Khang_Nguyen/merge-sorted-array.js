/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */

 var merge = function(nums1, m, nums2, n) {
    if (n === 0) return;
  
    // delete all rightmost 0
    nums1.splice(m, nums1.length - m)
  
    if (m === 0) {
      nums2.forEach((num) => {
        nums1.push(num)
      })
      return;
    }
    
    let i = 0
    let j = 0

    while (j < n) {
      if (nums2[j] <= nums1[i]) {
        nums1.splice(i, 0, nums2[j])
        j++
      } else if (i === nums1.length - 1) {
        nums1.push(nums2[j])
        j++;
      }
      i++
    }
  return;
};