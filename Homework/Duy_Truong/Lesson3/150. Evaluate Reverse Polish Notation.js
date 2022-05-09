
var evalRPN = function(tokens) {
    let stack = []
    let calculator = {
    '+': (a, b) => a + b,
    '-': (a, b) => a - b,
    '*': (a, b) => a * b,
    '/': (a, b) => Math.trunc(a / b),
    }
    while (tokens.length) {
        let next = tokens.shift()
        switch(next) {
            case '+':
            case '-':
            case '*':
            case '/':
                let op2 = stack.pop()
                let op1 = stack.pop()
                stack.push(calculator[next](Number(op1), Number(op2)))
                break
            default:
                stack.push(next)
        }
    }
    return stack[0]
};