/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function (n) {
  let set = new Set();
  while (!set.has(n)) {
    set.add(n);
    let sum = 0;
    while (n) {
      sum += Math.pow(n % 10, 2);
      n = Math.floor(n / 10);
    }

    if (sum === 1) {
      return true;
    }
    n = sum;
  }
  return false;
};
