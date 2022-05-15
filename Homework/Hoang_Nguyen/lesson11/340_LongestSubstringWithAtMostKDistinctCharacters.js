/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var lengthOfLongestSubstringKDistinct = function (s, k) {
  let start = 0;
  // current distinct chars number in current window
  let kCount = 0;
  let res = 0;
  const map = new Map();
  for (let end = 0; end < s.length; end++) {
    const endCount = map.get(s[end]) || 0;
    map.set(s[end], endCount + 1);
    if (!endCount) {
      kCount++;
    }
    if (kCount <= k) {
      res = Math.max(res, end - start + 1);
    } else {
      while (kCount > k) {
        // shrink window until it contains k distinct chars
        const startCount = map.get(s[start]);
        if (startCount === 1) {
          kCount--;
        }
        map.set(s[start], startCount - 1);
        start++;
      }
    }
  }
  return res;
};
