/**
 * @param {number[][]} points
 * @param {number} k
 * @return {number[][]}
 */
var kClosest = function(points, k) {
    points.sort((a,b) => sqrtCal(a[0], a[1]) - sqrtCal(b[0], b[1]))
    let arr = []
    for(let i=0;i<k;i++) {
        arr.push(points[i])
    }
    return arr
};

var sqrtCal = function(x, y) {
    return Math.sqrt(Math.pow(x,2) + Math.pow(y,2))
}