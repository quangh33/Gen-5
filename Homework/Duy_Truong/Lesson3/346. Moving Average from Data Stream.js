/**
 * @param {number} size
 */
var MovingAverage = function(size) {
    this.size = size;
    this.curr = 0;
    this.arr = [];
};

/** 
 * @param {number} val
 * @return {number}
 */
MovingAverage.prototype.next = function(val) {
    this.curr++; this.arr.push(val)
    if(this.curr > this.size) {
        this.curr = this.size;
        this.arr.shift()
    } 
    return (this.arr.reduce((x,y) => x+y))/this.curr;
}
/** 
 * Your MovingAverage object will be instantiated and called as such:
 * var obj = new MovingAverage(size)
 * var param_1 = obj.next(val)
 */