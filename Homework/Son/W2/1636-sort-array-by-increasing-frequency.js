/**
 * @param {number[]} nums
 * @return {number[]}
 */
 var frequencySort = function(nums) {
    let map = new Map();
    for (let n of nums) {
      map.set(n, map.get(n) + 1 || 1);
    }
    return nums.sort((a, b) =>
      map.get(a) === map.get(b) ? b - a : map.get(a) - map.get(b)
    );
  };

//   https://leetcode.com/problems/sort-array-by-increasing-frequency/