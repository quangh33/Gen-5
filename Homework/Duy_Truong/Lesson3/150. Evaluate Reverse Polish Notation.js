/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function(tokens) {
    let stack = []
    let calculator = {
    '+': (a, b) => a + b,
    '-': (a, b) => a - b,
    '*': (a, b) => a * b,
    '/': (a, b) => Math.trunc(a / b),
    }
    let num1 = 0; let num2 = 0;
    for(let i=0;i<tokens.length;i++) {
        switch(tokens[i]) {
            case '+':
                num1 = stack.pop()
                num2 = stack.pop()
                stack.push(Number(num2) + Number(num1))
                break;
            case '-':
                num1 = stack.pop()
                num2 = stack.pop()
                stack.push(Number(num2) - Number(num1))
                break;
            case '*':
                num1 = stack.pop()
                num2 = stack.pop()
                stack.push(Number(num2) * Number(num1))
                break;
            case '/':
                num1 = stack.pop()
                num2 = stack.pop()
                stack.push(Math.trunc(Number(num2) / Number(num1)))
                break; 
            default:
                stack.push(tokens[i]);
                break;
        }
    }
    return stack.pop()
};