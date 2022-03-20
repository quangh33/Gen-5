/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    if(s.length == 1) return false
    let res = []
    for(let i=0;i<s.length;i++) {
        if(s[i] === '(' || s[i] === '[' || s[i] === '{')
            res.push(s[i])
        else {
            if((s[i] == ')' && res[res.length-1] != '(')
              ||(s[i] == ']' && res[res.length-1] != '[')
              ||(s[i] == '}' && res[res.length-1] != '{'))
                return false
            res.pop()
        }
    }
    return res.length == 0
};