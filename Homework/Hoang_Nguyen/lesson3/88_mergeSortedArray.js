/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function (nums1, m, nums2, n) {
  let i1 = m - 1;
  let i2 = n - 1;
  let j = m + n - 1;
  // insert element from tail to head of nums1
  for (; j >= 0; j--) {
    if (i2 < 0) {
      break;
    }
    if (nums1[i1] > nums2[i2]) {
      nums1[j] = nums1[i1];
      i1--;
    } else {
      nums1[j] = nums2[i2];
      i2--;
    }
  }
  // insert remaining elements into nums1
  for (; i2 >= 0; i2--) {
    nums1[j] = nums2[i2];
    j--;
  }
};
