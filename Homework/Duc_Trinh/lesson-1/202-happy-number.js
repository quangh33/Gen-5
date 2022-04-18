/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function (n) {
  const hashmap = {};
  let sumSquared = n;
  while (true) {
    const digits = sumSquared.toString().split("");
    sumSquared = digits.reduce((acc, cur) => {
      return acc + Math.pow(parseInt(cur), 2);
    }, 0);
    if (sumSquared === 1 || hashmap[sumSquared]) break;
    hashmap[sumSquared] = true;
  }
  return sumSquared === 1;
};
