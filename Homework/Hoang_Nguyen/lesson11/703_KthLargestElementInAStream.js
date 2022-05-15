/**
 * @param {number} k
 * @param {number[]} nums
 */
var KthLargest = function (k, nums) {
  this.minPQ = new MinPriorityQueue();
  this.k = k;
  nums.forEach((num) => {
    this.add(num);
  });
};

/**
 * @param {number} val
 * @return {number}
 */
KthLargest.prototype.add = function (val) {
  this.minPQ.enqueue(val);
  if (this.minPQ.size() > this.k) {
    this.minPQ.dequeue();
  }
  return this.minPQ.front().element;
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = new KthLargest(k, nums)
 * var param_1 = obj.add(val)
 */
