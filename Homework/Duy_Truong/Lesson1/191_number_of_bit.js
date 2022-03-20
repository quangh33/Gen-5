/**
 * @param {number} n - a positive integer
 * @return {number}
 */

//time complex = O(1), space = O(1)
var hammingWeight = function(n) {
    let count = 0;
    while(n != 0) {
        count++;
        n &= (n-1);
    }
    return count
};