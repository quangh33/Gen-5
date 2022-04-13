/**
 * @param {string[]} tokens
 * @return {number}
 */
 var evalRPN = function(tokens) {
    var math_it_up = {
        '+': function ([x, y]) { return x + y },
        '-': function ([x, y]) { return x - y },
        '*': function ([x, y]) { return x * y },
        '/': function ([x, y]) { 
            if (x/y > 0) return Math.floor(x / y) 
            else return Math.ceil(x/y)
        },
    };
    let numStack = []
    for (let token of tokens) {
        if (token !== "+" && token !== "-" && token !== "*" && token !== "/") {
            numStack.push(parseInt(token))} 
        else {
            let calculation = math_it_up[token](numStack.slice(-2))
            numStack.pop()
            numStack.pop()
            numStack.push(calculation)
        }
    }
    return numStack[0]
};

// https://leetcode.com/problems/evaluate-reverse-polish-notation/