/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function (s, t) {
  const mapS = new Map();
  const mapT = new Map();
  for (let i = 0; i < t.length; i++) {
    mapT.set(t[i], (mapT.get(t[i]) || 0) + 1);
    mapS.set(t[i], 0);
  }
  // number of chars of string t in current window
  let sCount = 0;
  let start = 0;
  let res = '';

  for (let end = 0; end < s.length; end++) {
    if (!mapS.has(s[end])) {
      continue;
    }
    const endCount = mapS.get(s[end]);
    mapS.set(s[end], endCount + 1);
    if (endCount + 1 > mapT.get(s[end])) {
      continue;
    }
    sCount++;
    while (sCount === t.length) {
      // save current minimum window
      if (!res.length || end - start + 1 < res.length) {
        res = s.slice(start, end + 1);
      }
      // shrink current window to find the minimum window
      if (mapS.has(s[start])) {
        const startCount = mapS.get(s[start]);

        if (startCount === mapT.get(s[start])) {
          sCount--;
        }
        mapS.set(s[start], startCount - 1);
      }
      start++;
    }
  }
  return res;
};
