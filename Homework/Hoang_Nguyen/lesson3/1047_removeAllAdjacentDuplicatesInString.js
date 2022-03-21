/**
 * @param {string} s
 * @return {string}
 */
var removeDuplicates = function (s) {
  const stack = [];
  for (const i of s) {
    if (!stack.length) {
      stack.push(i);
    } else {
      if (stack[stack.length - 1] === i) {
        stack.pop();
      } else {
        stack.push(i);
      }
    }
  }
  return stack.join('');
};
