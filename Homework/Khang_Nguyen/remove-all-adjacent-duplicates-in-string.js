// O(1) space, O(n) time, no stack
/**
 * @param {string} s
 * @return {string}
 */
var removeDuplicates = function(s) {
  const len = s.length
  if (len < 2) return s
  let i = 0;
  let j = 1;
  while (j < s.length) {
    if (s[i] !== s[j]) {
      j++
      i++
    } else {
      s = s.slice(0, i) + s.slice(j + 1) 
      i--
      j--
    }
  }
  return s
};