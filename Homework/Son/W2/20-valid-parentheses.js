/**
 * @param {string} s
 * @return {boolean}
 */
 var isValid = function(s) {
    if (s.length === 1) return false
    let parenthesisStack = []
    for (let c of s) {
        if (c === "(" || c === "{" || c === "[") parenthesisStack.push(c)
        switch (c) {
            case ")":
                if (parenthesisStack.length === 0) return false;
                if (parenthesisStack[parenthesisStack.length -1] === "(") parenthesisStack.pop();
                else return false;
                break;
            case "}":
                if (parenthesisStack.length === 0) return false;
                if (parenthesisStack[parenthesisStack.length -1] === "{") parenthesisStack.pop();
                else return false;
                break;
            case "]":
                if (parenthesisStack.length === 0) return false;
                if (parenthesisStack[parenthesisStack.length -1] === "[") parenthesisStack.pop();
                else return false;
                break;
            default:
                break;
        }
    }
    if (parenthesisStack.length > 0) return false
    else return true
};

// https://leetcode.com/problems/valid-parentheses/