/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function (x, n) {
  function powPos(x, n) {
    if (n === 0) return 1;
    if (n === 1) return x;
    const p = powPos(x, Math.floor(n / 2));
    if (n % 2) return p * p * x;
    return p * p;
  }

  if (n > 0) return powPos(x, n);
  return 1 / powPos(x, -n);
};
