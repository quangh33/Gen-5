// https://leetcode.com/problems/number-of-1-bits/submissions/

/**
 * @param {number} n - a positive integer
 * @return {number}
 */
 var hammingWeight = function(n) {
    // totalCount = 0;
    // let text = n.toString(2)
    // for (let i = 0; i< text.length; i++) {
    //     if (text[i] == 1) totalCount++;
    // }
    // return totalCount;
    
    let sum  =0;
    while (n != 0) {
        sum++
        n &= (n-1);
    }
    return sum;
};