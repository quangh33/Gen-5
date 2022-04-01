// O(1) space and O(n) time
var evalRPN = function(tokens) {
    if (tokens.length < 2) return tokens[0]
    
    let i = 0
    let j = 1
    while (j < tokens.length) {
        if (tokens[j].match(/[0-9]/g)) {
            i++
            j++
        } else {
            const a = parseInt(tokens[i - 1], 10)
            const b = parseInt(tokens[j - 1], 10)
            let result = cal(a, b, tokens[j]) 
            tokens = tokens.slice(0, i - 1).concat(result.toString(),...tokens.slice(j + 1))
            j--
            i--
        }
    }
    return tokens[0]
};
function cal(a, b, executor) {
    switch (executor) {
        case '+':
            return a + b
        case '-':
            return a - b
        case '/':
            const result = a / b
            return result > 0 ? Math.floor(result) : Math.ceil(result)
        case '*':
            return a * b
    }
}