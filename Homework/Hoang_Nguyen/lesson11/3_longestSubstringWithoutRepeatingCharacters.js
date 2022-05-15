/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
  let res = 0;
  let start = 0,
    end = 0;
  const map = new Map(); // (char => index in s) map
  while (end < s.length) {
    // shrink the sliding window if repeating char is in current window
    if (map.has(s[end]) && map.get(s[end]) >= start) {
      start = map.get(s[end]) + 1;
    }
    res = Math.max(res, end - start + 1);
    map.set(s[end], end);
    end++;
  }
  return res;
};
