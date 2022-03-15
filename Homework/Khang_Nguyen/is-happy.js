// /**
//  * @param {number} n
//  * @return {boolean}
//  */
//  var isHappy = function(n) {
//     const freq = { [n]: 1 }
//     let clone = n
//     let result = true
//     while (clone !== 1) {
//         clone = clone.toString().split('').reduce((total, digit) => {
//             const num = parseInt(digit)
//             return total + num*num
//         }, 0)
//         if (freq[clone]) {
//             result = false
//             break;
//         } else {
//             freq[clone] = 1
//         }
//     }
//     return result
// };
i/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
  let slow = squareDigit(n)
  let fast = squareDigit(slow)

  while (slow !== fast) {
      slow = squareDigit(slow)
      fast = squareDigit(fast)
      if (fast === slow) break;
      
      fast = squareDigit(fast)
      if (fast === slow) break;
  }
  return slow === 1
};

function squareDigit(n) {
    let sum = 0;
    let temp;
    while (n > 0) {
        temp = n % 10
        sum = sum + temp * temp
        n = Math.floor(n/10)
    }
    return sum
}