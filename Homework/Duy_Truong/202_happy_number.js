/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
    let set = new Set
    while(true) {
        let nString = (n).toString();
        let sum = 0;
        for(let i=0;i<nString.length;i++) {
            sum += Math.pow(nString[i],2);
        }
        n = sum;
        if(sum == 1) break;   
        if(set.has(n)) return false;
        set.add(n);
    }
    return true;
};