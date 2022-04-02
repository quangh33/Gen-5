/**
 * @param {string} s
 * @return {string}
 */

// Use stack approach
// var removeDuplicates = function(s) {
//     let checkStack = [];
//     for (let i = 0; i <s.length; i++) {
//         if (s[i] !== checkStack[checkStack.length-1]) checkStack.push(s[i])
//         else {
//             checkStack.pop()
//         }
//     }
//     return checkStack.join('');
// };

const removeDuplicates = (s, result = []) => {
    s.split("").forEach((el) =>
      el !== result[result.length - 1] ? result.push(el) : result.pop()
    );
      
    return result.join("");
  };
  
  