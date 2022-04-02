/**
 * @param {number} n
 * @return {boolean}
 */
 var isHappy = function(n) {
    function getNext(num) {
        let res = 0;
        while (num > 0) {
            d = num % 10;
            num = parseInt(num/10);
            res += d * d;
        }
        return res;
    }
    let cycleSet = new Set()
    while (n !== 1) {
        if (!cycleSet.has(n)) cycleSet.add(n)
        else if (cycleSet.has(n)) return false
        n = getNext(n)
    }
    return true;
};

// https://leetcode.com/problems/happy-number/