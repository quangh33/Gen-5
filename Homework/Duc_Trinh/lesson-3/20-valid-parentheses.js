/**
 * @param {string} s
 * @return {boolean}
 */
 var isValid = function(s) {
    const bracketsMap = {
        '{': '}',
        '[': ']',
        '(': ')',
    }
    let stack = []
    for (let i = 0; i < s.length; i++) {
        if (Object.keys(bracketsMap).indexOf(s[i]) > -1) {
            stack.push(s[i])
        } else {
            const top = stack[stack.length - 1]
            if (s[i] === bracketsMap[top]) {
                stack.pop()
            } else {
                return false
            }
        }
    }
    return stack.length === 0
  };