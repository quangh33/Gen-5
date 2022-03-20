/**
 * @param {number} n
 * @return {boolean}
 */

// time complex = O(log2(below)n), space = O(n) 
var isPowerOfTwo = function(n) {
    if(n <= 0) return false;
    if(n == 1 || n == 2) return true;
    while(n > 2) {
        n /= 2;
        if(n%2 != 0)
            return false
    }
    return true;
};

// time complex = O(1), space = O(1) 
var isPowerOfTwo = function(n) {
    if(n <= 0) return false;
    let checkPowerOfTwo = n&(n-1)
    return checkPowerOfTwo == 0;
};