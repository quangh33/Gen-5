/**
 * @param {number} n
 * @return {boolean}
 */
 var isPowerOfTwo = function(n) {
    let powerCheck = 1 
    while (powerCheck <= n)
        {
            if (powerCheck === n) return true;
            powerCheck = 2*powerCheck;
        }
    return false;
};