var MovingAverage = function(size) {
    this.size = size
    this.sum = 0
    this.stack = []
};

/** 
 * @param {number} val
 * @return {number}
 */
MovingAverage.prototype.next = function(val) {
    this.sum = this.sum + val
    this.stack.push(val)
    if (this.stack.length > this.size) {
        this.sum = this.sum - this.stack.shift()
    }
    return this.sum/this.stack.length
};
