/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function (tokens) {
  const stack = [];
  for (const c of tokens) {
    if (['+', '-', '*', '/'].includes(c)) {
      const num2 = parseInt(stack.pop());
      const num1 = parseInt(stack.pop());
      let result;
      if (c === '+') {
        result = num1 + num2;
      } else if (c === '-') {
        result = num1 - num2;
      } else if (c === '*') {
        result = num1 * num2;
      } else if (c === '/') {
        result = num1 / num2;
      }
      stack.push(result);
    } else {
      stack.push(c);
    }
  }
  return parseInt(stack[0]);
};
