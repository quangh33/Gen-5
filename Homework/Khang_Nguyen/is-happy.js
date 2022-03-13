/**
 * @param {number} n
 * @return {boolean}
 */
 var isHappy = function(n) {
    const freq = { [n]: 1 }
    let clone = n
    let result = true
    while (clone !== 1) {
        clone = clone.toString().split('').reduce((total, digit) => {
            const num = parseInt(digit)
            return total + num*num
        }, 0)
        if (freq[clone]) {
            result = false
            break;
        } else {
            freq[clone] = 1
        }
    }
    return result
};