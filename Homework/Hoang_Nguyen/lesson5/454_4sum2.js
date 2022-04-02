/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @param {number[]} nums3
 * @param {number[]} nums4
 * @return {number}
 */
var fourSumCount = function (nums1, nums2, nums3, nums4) {
  const map1 = new Map();

  for (const n1 of nums1) {
    for (const n2 of nums2) {
      const sum = n1 + n2;
      map1.set(sum, (map1.get(sum) || 0) + 1);
    }
  }
  let result = 0;
  for (const n3 of nums3) {
    for (const n4 of nums4) {
      const sum = n3 + n4;
      result += map1.get(-sum) || 0;
    }
  }
  return result;
};
