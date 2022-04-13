/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function (s) {
  function isOpenBrackets(i) {
    return ['(', '{', '['].includes(i);
  }

  function isMatched(s1, s2) {
    return (
      (s1 === '(' && s2 === ')') ||
      (s1 === '{' && s2 === '}') ||
      (s1 === '[' && s2 === ']')
    );
  }

  const stack = [];
  for (let i of s) {
    if (isOpenBrackets(i)) {
      stack.push(i);
    } else if (stack.length) {
      if (!isMatched(stack[stack.length - 1], i)) {
        return false;
      }
      stack.pop();
    } else {
      return false;
    }
  }
  return !stack.length;
};
