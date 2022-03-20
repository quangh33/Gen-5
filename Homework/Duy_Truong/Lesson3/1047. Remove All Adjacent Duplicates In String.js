/**
 * @param {string} s
 * @return {string}
 */
var removeDuplicates = function(s) {
    if(s.length == 0) return ''
    let res = [s[0]]
    for(let i=1;i<s.length;i++) {
        if(res[res.length-1] === s[i])
            res.pop()
        else
            res.push(s[i])
    }
    
    return res.join('')
};