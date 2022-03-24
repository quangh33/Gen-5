/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function (n) {
  var n_binary = n.toString(2);
  var n_array = n_binary.split("");
  var count = 0;
  for (let i = 0; i < n_array.length; i++) {
    if (n_array[i] == "1") {
      count++;
    }
  }
  return count;
};
