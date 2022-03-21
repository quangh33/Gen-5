/**
 * @param {number} size
 */
var MovingAverage = function (size) {
  this.arr = [];
  this.maxSize = size;
  this.sum = 0;
  this.size = 0;
};

/**
 * @param {number} val
 * @return {number}
 */
MovingAverage.prototype.next = function (val) {
  if (this.size === this.maxSize) {
    this.sum -= this.arr[0];
    this.arr.shift(); // remove first element
  } else {
    this.size++;
  }
  this.arr.push(val);
  this.sum += val;
  return this.sum / this.size;
};

/**
 * Your MovingAverage object will be instantiated and called as such:
 * var obj = new MovingAverage(size)
 * var param_1 = obj.next(val)
 */
var obj = new MovingAverage(3);
console.log(obj.next(1));
console.log(obj.next(10));
console.log(obj.next(3));
console.log(obj.next(5));
