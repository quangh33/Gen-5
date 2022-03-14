/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function (n) {
  function nToSum(n) {
    let sum = 0;
    while (n) {
      sum += Math.pow(n % 10, 2);
      n = Math.floor(n / 10);
    }
    return sum;
  }

  let slow = n;
  let fast = n;

  while (fast !== 1) {
    slow = nToSum(slow);
    fast = nToSum(fast);
    if (fast === 1) {
      break;
    }
    fast = nToSum(fast);

    if (slow === fast) {
      return false;
    }
  }
  return true;
};

/**
 * @param {number} n
 * @return {boolean}
 */
var isHappyBySet = function (n) {
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
